package com.rozplochowski.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.atomic.AtomicInteger;

public class ResilientServer {
    private final AtomicInteger connectionCount = new AtomicInteger(0);
    private final AtomicInteger activeConnections = new AtomicInteger(0);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static void main() throws IOException, InterruptedException {
        var server = new ResilientServer();

        try (var serverSocket = new ServerSocket(2626)) {
            server.serve(serverSocket);
        }

    }

    public void serve(ServerSocket serverSocket) throws IOException, InterruptedException {
        log("Server starting on port: %d".formatted(serverSocket.getLocalPort()));

        var threadFactory = Thread.ofVirtual()
                .name("handler-", 0)
                .factory();

        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.awaitAll(), cf ->
                cf.withTimeout(Duration.ofSeconds(10))
                        .withThreadFactory(threadFactory)
                        .withName("ConnectionHandler")
                )) {
            serverSocket.setSoTimeout(1000);

            while (!Thread.currentThread().isInterrupted()) {

                try {
                    Socket socket = serverSocket.accept();
                    int connId = connectionCount.incrementAndGet();
                    activeConnections.incrementAndGet();

                    log("Accepted connection: %d".formatted(connId));

                    scope.fork(() -> {
                        handleConnection(socket, connId);
                        return null;
                    });
                } catch (SocketTimeoutException timeoutException) {
                    continue;
                }

            }

            log("Stopping server, waiting for all connections to finish...");
            scope.join();
        } finally {
            if (!serverSocket.isClosed()) {
                serverSocket.close();
            }
            log("Shutdown completed, total connections: %d".formatted(connectionCount.get()));
        }

    }

    private void handleConnection(Socket socket, int connectionId) {
        try (socket; var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new PrintWriter(socket.getOutputStream(), true)) {
            log("[Conn%d] started".formatted(connectionId));

            writer.println("Welcome to Echo Server. Type 'quit' to exit.");

            String line;
            while ((line = reader.readLine()) != null) {
                log("[Conn%d] received: %s".formatted(connectionId, line));

                if ("quit".equalsIgnoreCase(line.trim())) {
                    writer.println("Goodbye!");
                    break;
                }

                writer.println("Echo %s".formatted(line));
            }

            log("[Conn%d] finished".formatted(connectionId));
        } catch (IOException e) {
            log("[Conn%d] failed, message: %s".formatted(connectionId, e.getMessage()));
        } finally {
            activeConnections.decrementAndGet();
            log("[Conn%d] finished. Active: %d".formatted(connectionId, activeConnections.get()));
        }
    }

    private static void log(String message) {
        var time = LocalDateTime.now().format(FORMATTER);
        var thread = Thread.currentThread();
        var name = thread.isVirtual()
                ? "VThread[#%d]".formatted(thread.threadId())
                : thread.getName();

        IO.println("%s %-12s: %s".formatted(time, thread.getName(), message));
    }
}
