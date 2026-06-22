package com.rozplochowski.coding.prefixsum;

/**
 * There is a biker going on a road trip. The road trip consists of n + 1 points at various altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.
 * <p></p>
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n).
 * Return the highest altitude of a point.
 */
public class FindHighestAltitude {

    public static int largestAltitude(int[] gain) {
        var max = 0;
        var current = 0;
        for (var i = 1; i <= gain.length; i++) {
            current += gain[i - 1];
            max = Math.max(current, max);
        }

        return max;
    }
}
