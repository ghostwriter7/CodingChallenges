package com.rozplochowski.coding.javacollections;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    void main() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3); // can have unlimited size
        ArrayBlockingQueue<String> queue2 = new ArrayBlockingQueue<>(3); // cannot grow

        var consumer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    var task = queue.take();
                    IO.println("Consuming task: %s".formatted(task));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        consumer.start();

        var producer = new Thread(() -> {
            var count = 10;
            while (count != 0) {

                var task = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
                try {
                    IO.println("Adding task: %s".formatted(task));
                    queue.put(task);
                    count--;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            IO.println("Producer finished");
        });
        producer.start();

        producer.join();
        consumer.join();
    }
}
