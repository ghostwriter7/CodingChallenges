package com.rozplochowski.coding.javacollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentSkipListMapDemo {

    /**
     * Think ConcurrentHashMap and TreeMap (sorted).
     * Thread-safe, sorted.
     * Internally, SkipList implementation.
     * O(log n) for get & put.
     */
    void main() throws ExecutionException, InterruptedException {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        map.put(1, "Hello");
        map.put(2, "World");

        try (var executor = Executors.newFixedThreadPool(4)) {
            String[] words = new String[]{"Wolf", "Bear", "Eagle"};
            List<Future<Void>> futures = new ArrayList<>();
            for (var word : words) {
                futures.add(executor.submit(() -> {
                    IO.println("Thread: " + Thread.currentThread().getName() + " is putting " + word);
                    IO.println("Thread: " + Thread.currentThread().getName() + " current value is " + map.get(3));

                    map.put(3, word);
                    return null;
                }));
            }

            for (var future : futures) {
                future.get();
            }

        }

        IO.println(map);
    }
}
