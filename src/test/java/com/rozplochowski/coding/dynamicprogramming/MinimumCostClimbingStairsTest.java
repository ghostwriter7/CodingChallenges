package com.rozplochowski.coding.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostClimbingStairsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testMinCostClimbingStairs(int[] cost, int expected) {
        int actual = new MinimumCostClimbingStairs().minCostClimbingStairs(cost);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
        );
    }

}