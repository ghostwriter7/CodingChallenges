package com.rozplochowski.concurrency;

public class ThreadLifecycle {

    static void main() throws InterruptedException {

        var t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                IO.println(Thread.currentThread().getName() + " has been interrupted");
            }
        });

        IO.println(t.getState()); // NEW

        t.start();

        IO.println(t.getState()); // RUNNABLE

        Thread.sleep(500);

        IO.println(t.getState()); // TIMED_WAITING

        Thread.sleep(2000);

        IO.println(t.getState()); // TERMINATED

        var t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                IO.println(Thread.currentThread().getName() + " has been interrupted");
            }
        });

        var t3 = new Thread(() -> {

            try {
                t2.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                IO.println(Thread.currentThread().getName() + " has been interrupted");
            }

        });

        t2.start();
        t3.start();

        Thread.sleep(1000);

        IO.println(t2.getState()); // TIMED_WAITING
        IO.println(t3.getState()); // WAITING

        var t4 = new Thread(ThreadLifecycle::synchronizedMethod);
        var t5 = new Thread(ThreadLifecycle::synchronizedMethod);

        t4.start();
        t5.start();

        Thread.sleep(100);

        IO.println(t4.getState()); // One is BLOCKED, another TIMED_WAITING
        IO.println(t5.getState());

    }

    private static synchronized void synchronizedMethod() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
