package com.rozplochowski.coding.javacollections;

import java.util.IdentityHashMap;

public class IdentityHashMapDemo {

    void main() {
        IdentityHashMap<Object, String> map = new IdentityHashMap<>();

        var key = new Object();
        var key2 = new Object();

        map.put(key, "Hello");
        map.put(key2, "World");

        var hashCode = System.identityHashCode(key);
        IO.println(hashCode);

        IO.println(map.get(key));
        IO.println(map.get(key2));
    }
}
