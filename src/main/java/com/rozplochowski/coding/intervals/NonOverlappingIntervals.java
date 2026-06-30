package com.rozplochowski.coding.intervals;

import java.util.Arrays;

/**
 * Given an array of intervals `intervals` where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        var end = intervals[0][1];
        var count = 0;

        for (var i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}
