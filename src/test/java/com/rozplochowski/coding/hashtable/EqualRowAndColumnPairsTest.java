package com.rozplochowski.coding.hashtable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EqualRowAndColumnPairsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeEqualRowAndColumnPairs(int[][] matrix, int expected) {
        assertEquals(expected, EqualRowAndColumnPairs.equalPairs(matrix));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                Arguments.of(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3),
                Arguments.of(new int[][]{{2, 1}, {3, 32}}, 0)
        );
    }

}