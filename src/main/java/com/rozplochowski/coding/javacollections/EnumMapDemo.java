package com.rozplochowski.coding.javacollections;

import java.util.EnumMap;

public class EnumMapDemo {

    /**
     * Backed-up by an array with using ordinal value of enum constants for access.
     */
    static void main(String[] args) {
        EnumMap<Color, String> map = new EnumMap<>(Color.class);

        map.put(Color.RED, "Rose");
        map.put(Color.GREEN, "Grass");
        map.put(Color.BLUE, "Sky");

        for (var entry : map.entrySet()) {
            IO.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    enum Color {RED, GREEN, BLUE}
}
