package com.rozplochowski.coding.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (var num : arr) {
            occurrences.merge(num, 1, Integer::sum);
        }

        var unique = new HashSet<Integer>();
        for (var count : occurrences.values()) {
            if (!unique.add(count)) return false;
        }

        return true;
    }
}
