package com.rozplochowski.coding.prefixsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindPivotIndex(int[] input, int expected) {
        assertEquals(expected, FindPivotIndex.pivotIndex(input));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{2, 1, -1}, 0)
        );
    }

}