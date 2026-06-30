package com.rozplochowski.coding.intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void eraseOverlapIntervals(int[][] intervals, int expected) {
        assertEquals(expected, new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }

    private static Object[][] cases() {
        return new Object[][]{
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1},
                {new int[][]{{1, 2}, {1, 2}, {1, 2}}, 2},
                {new int[][]{{1, 2}, {2, 3}}, 0},
                {new int[][]{{1, 11}, {2, 12}, {11, 22}, {1, 100}}, 2}
        };
    }

}