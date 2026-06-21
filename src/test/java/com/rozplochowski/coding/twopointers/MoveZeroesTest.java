package com.rozplochowski.coding.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testMoveZeroes(int[] input, int[] expected) {
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5, 0})
        );
    }

}