package com.rozplochowski.coding.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAverageSubarrayTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldFindMaxAverage(int[] input, int k, double expected) {
        var actual = MaximumAverageSubarray.findMaxAverage(input, k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75),
                Arguments.of(new int[]{5}, 1, 5.0)
        );
    }

}