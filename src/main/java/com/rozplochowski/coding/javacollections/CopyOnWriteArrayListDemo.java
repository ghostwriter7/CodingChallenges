package com.rozplochowski.coding.javacollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CopyOnWriteArrayListDemo {

    void main() throws ExecutionException, InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        new CopyOnWriteArraySet<String>(); // uses CopyOnWriteArrayList internally
        list.add(1);
        list.add(2);
        list.add(3);

        try (var executor = Executors.newFixedThreadPool(4)) {
            List<Future<Void>> futures = new ArrayList<>();

            for (var i = 0; i < 4; i++) {

                futures.add(
                        executor.submit(() -> {
                            var r = new Random();
                            var v = r.nextInt();
                            IO.println("Thread %s is adding %s".formatted(Thread.currentThread().getName(), v));
                            list.add(v);

                            var sb = new StringBuilder();
                            for (var value : list) {
                                sb.append(value).append(", ");
                            }
                            IO.println("Thread %s finished iteration and read values: %s".formatted(Thread.currentThread().getName(), sb));
                            return null;
                        })
                );

            }

            for (var f : futures)
                f.get();
        }
    }
}
