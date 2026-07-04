package com.rozplochowski.coding.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {


    @Test
    void test() {
        var map = new HashMap<Integer, Integer>();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        assertEquals(1, map.get(1));
        assertEquals(2, map.get(2));
        assertEquals(3, map.get(3));
        assertNull(map.get(4));
        assertEquals(3, map.size());

        map.remove(2);
        assertEquals(2, map.size());
        assertEquals(1, map.get(1));
        assertNull(map.get(2));
        assertEquals(3, map.get(3));

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(4));

        var iter = map.iterator();

        assertTrue(iter.hasNext());
        assertEquals(new HashMap.Pair<>(1, 1), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(new HashMap.Pair<>(3, 3), iter.next());
        assertFalse(iter.hasNext());
    }
}