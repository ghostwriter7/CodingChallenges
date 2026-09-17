package com.rozplochowski.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

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


    }


}
