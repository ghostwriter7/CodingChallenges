package com.rozplochowski.concurrency;

import java.util.Set;
import java.util.concurrent.*;

public class CompletableFutureUseCases {

    static void main() throws ExecutionException, InterruptedException {
        demoOne();
    }

    private static void demoOne() throws ExecutionException, InterruptedException {

        var cf0 = new CompletableFuture<Long>();
        cf0.complete(100L);
        IO.println(cf0.join());

        // **************************************************

        var cf1 = CompletableFuture.supplyAsync(() -> "Hello " + Thread.currentThread().getName());
        var cf2 = CompletableFuture.supplyAsync(() -> "Hello " + Thread.currentThread().getName());

        var both = CompletableFuture.allOf(cf1, cf2);

        both.join();

        IO.println("%s, %s".formatted(cf1.get(), cf2.get()));

        // **************************************************

        var cf3 = CompletableFuture.runAsync(() -> IO.println("Hello " + Thread.currentThread().getName()));
        var cf4 = CompletableFuture.runAsync(() -> IO.println("Hello " + Thread.currentThread().getName()));

        var both2 = CompletableFuture.allOf(cf3, cf4);
        both2.join();

        // **************************************************

        var cf5 = CompletableFuture.failedFuture(new RuntimeException("Something went wrong"));
        var cf6 = CompletableFuture.completedFuture("Hello");

        var anyOf = CompletableFuture.anyOf(cf5, cf6);

        try {
            anyOf.join();
        } catch (CompletionException e) {
            IO.println(e.getCause().getMessage());
        }

        // **************************************************

        try (var executor = Executors.newFixedThreadPool(1)) {

            var cf7 = CompletableFuture.supplyAsync(() -> "Hello " + Thread.currentThread().getName(), executor);

            IO.println(cf7.join());
        }

        // **************************************************

        var executor = Executors.newFixedThreadPool(1);
        try {
            var cf8 = CompletableFuture.runAsync(() -> IO.println("Hello " + Thread.currentThread().getName()), executor);
            cf8.join();
        } finally {
            executor.shutdown();
        }

        // **************************************************

        getUserId()
                .thenComposeAsync(CompletableFutureUseCases::getProductsByUserId)
                .join();

        // **************************************************

        var cf9 = CompletableFuture.supplyAsync(() -> {
                    IO.println(Thread.currentThread().getName() + " computes a secret number");
                    return ThreadLocalRandom.current().nextLong();
                })
                .thenApply(v -> {
                    IO.println(Thread.currentThread().getName() + " multiplies a secret number " + v);
                    return v * ThreadLocalRandom.current().nextInt(0, 500);
                })
                .thenAccept(v -> IO.println(Thread.currentThread().getName() + " prints a secret number " + v))
                .join();

        // **************************************************

        CompletableFuture.supplyAsync(() -> {

            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new RuntimeException("Random Exception");
            }

            return 5000;
        })
                .thenApplyAsync(v -> v * 2)
                .thenAcceptAsync(v -> IO.println(Thread.currentThread().getName() + " prints 'v': " + v))
                .exceptionallyAsync(ex -> {
                    IO.println(Thread.currentThread().getName() + " handles exception: " + ex.getMessage());
                    return null;
                })
                .join();

        // **************************************************

        CompletableFuture.supplyAsync(() -> 1)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> 2), Integer::sum)
                .thenComposeAsync(v -> CompletableFuture.supplyAsync(() -> v * 2))
                .thenApplyAsync(v -> v + 51)
                .thenAcceptAsync(v -> IO.println(Thread.currentThread().getName() + " prints 'v': " + v))
                .join();

    }

    private static CompletableFuture<Long> getUserId() {
        return CompletableFuture.supplyAsync(() -> {
            IO.println(Thread.currentThread().getName() + " fetches user ID");
            return 1L;
        });
    }

    private static CompletableFuture<Set<String>> getProductsByUserId(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println(Thread.currentThread().getName() + " fetches products for user ID " + id);
            return Set.of("Book", "Notebook");
        });
    }
}
