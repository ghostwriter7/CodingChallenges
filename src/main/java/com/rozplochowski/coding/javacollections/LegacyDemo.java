package com.rozplochowski.coding.javacollections;

import java.util.Hashtable;
import java.util.Vector;

public class LegacyDemo {

    void main() {
        Hashtable<String, Integer> map = new Hashtable<>();
        map.put("Hello", 1);
        map.put("World", 2);

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        IO.println(map);
        IO.println(vector);
    }
}
