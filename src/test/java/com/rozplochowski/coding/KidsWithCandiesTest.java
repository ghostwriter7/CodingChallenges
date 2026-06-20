package com.rozplochowski.coding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KidsWithCandiesTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldComputeKidsWithCandies(int[] candies, int extraCandies, boolean[] expected) {
        var actual = new KidsWithCandies().kidsWithCandies(candies, extraCandies);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5, 1, 3}, 3, new boolean[]{true, true, true, false, true}),
                Arguments.of(new int[]{4, 2, 1, 1, 2}, 1, new boolean[]{true, false, false, false, false}),
                Arguments.of(new int[]{12, 1, 12}, 10, new boolean[]{true, false, true})
        );
    }

}