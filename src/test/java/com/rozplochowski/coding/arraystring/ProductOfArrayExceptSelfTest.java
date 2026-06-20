package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldComputeProductOfArrayExceptSelf(int[] input, int[] expected) {
        var actual = new ProductOfArrayExceptSelf().compute(input);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

}