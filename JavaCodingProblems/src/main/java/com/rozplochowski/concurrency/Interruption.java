package com.rozplochowski.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Interruption {

    private static final Logger LOGGER = Logger.getLogger(Interruption.class.getName());

    static void main() throws InterruptedException {
//        interruptWhileSleeping();
        interruptInALoop();
    }

    private static void interruptWhileSleeping() throws InterruptedException {
        var t1 = new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                LOGGER.warning("Thread interrupted");
                Thread.currentThread().interrupt();
            }

            if (Thread.currentThread().isInterrupted()) {
                LOGGER.info("Entered the block after interruption");
            }

        });

        t1.start();

        Thread.sleep(1000);
        t1.interrupt();

        t1.join();

        LOGGER.info("Finished");
    }

    private static void interruptInALoop() throws InterruptedException {

        BlockingQueue<Long> q = new LinkedBlockingQueue<>();

        var t = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {

                try {
                    LOGGER.info(Thread.currentThread().getName() + " will attempt to poll from the queue for 3 seconds");

                    var value = q.poll(3, TimeUnit.SECONDS);
                    LOGGER.info("Polled value: " + value);
                } catch (InterruptedException e) {
                    LOGGER.warning(Thread.currentThread().getName() + " has been interrupted while polling!");
//                    Thread.currentThread().interrupt(); IF THE INTERRUPTION IS NOT RESTORED, THE LOOP NEVER EXITS!
                }

            }

            LOGGER.info(Thread.currentThread().getName() + " is exiting the loop");

        });

        t.start();
        Thread.sleep(1500);
        t.interrupt();

        t.join();

    }

}
