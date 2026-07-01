package com.rozplochowski.coding.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class RottenOrangesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeRottenOranges(int[][] grid, int expected) {
        assertEquals(expected, new RottenOranges().orangesRotting(grid));
    }

    private static Object[][] cases() {
        return new Object[][]{
                {new int[][]{{2,1,1},{1,1,0},{0,1,1}}, 4},
                {new int[][]{{2,1,1},{0,1,1},{1,0,1}}, -1},
                {new int[][]{{0,2}}, 0},
        };
    }
}