package com.rozplochowski.coding.javacollections;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

    void main() {
        WeakHashMap<String, Integer> map = new WeakHashMap<>();

        var test = "Hello";

        map.put(test, 1);

        IO.println(map.get(test));

        test = null;

        IO.println(map.get(test));
    }
}
