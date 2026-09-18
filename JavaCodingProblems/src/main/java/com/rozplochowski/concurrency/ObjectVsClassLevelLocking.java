package com.rozplochowski.concurrency;

public class ObjectVsClassLevelLocking {

    static void main() throws InterruptedException {
        var d = new Demo();

        var t1 = new Thread(() -> {
            d.synchronizedMethod();
            d.objectLocked();
            Demo.classLocked();
        });
        t1.start();
        t1.join();
    }

    private static class Demo {

        private final Object lock = new Object();

        private synchronized void synchronizedMethod() {
            IO.println("Inside synchronized method (instance)");

            anotherSynchronizedMethod(); // locking with `synchronized` is re-entrant
        }

        private synchronized void anotherSynchronizedMethod() {
            IO.println("Inside another synchronized method (instance)");
        }

        private void objectLocked() {
            synchronized(lock) {
                IO.println("Inside synchronized method (object)");
            }
        }

        private static synchronized void classLocked() {
            IO.println("Inside synchronized method (class)");
        }

    }

}
