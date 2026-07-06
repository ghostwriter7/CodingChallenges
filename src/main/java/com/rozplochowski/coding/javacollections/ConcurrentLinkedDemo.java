package com.rozplochowski.coding.javacollections;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedDemo {

    void main() throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        var producer = new Thread(() -> {
            var r = new Random();
            var left = 10;
            while (left != 0) {
                try {
                    Thread.sleep(500);

                    var value = r.nextInt(0, 100);
                    IO.println("Adding Task-%d".formatted(value));
                    queue.add("Task-%d".formatted(value));
                    left--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        var consumer = new Thread(() -> {
            var checks = 5;
            while (checks != 0) {
                try {
                    var task = queue.poll();

                    if (task != null) {
                        IO.println("Consuming Task-%s".formatted(task));
                        checks = 10;
                    } else {
                        checks--;
                        IO.println("No task to consume");
                    }
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
