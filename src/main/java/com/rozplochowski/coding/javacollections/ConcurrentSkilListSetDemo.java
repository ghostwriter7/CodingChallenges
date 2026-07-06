package com.rozplochowski.coding.javacollections;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkilListSetDemo {

    /**
     * Backed by a ConcurrentSkipListMap.
     */
    void main() {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

        set.add(1);
        set.add(2);
    }
}
