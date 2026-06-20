package com.rozplochowski.coding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldComputeCanPlaceFlowers(int[] flowerbed, int n, boolean expected) {
        var actual = new CanPlaceFlowers().canPlaceFlowers(flowerbed, n);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false),
                Arguments.of(new int[]{0, 0, 1, 0, 0}, 1, true),
                Arguments.of(new int[]{0, 0, 1, 0, 0}, 2, true),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 3, true),
                Arguments.of(new int[]{0, 1, 0, 0, 0}, 3, false),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0, true)
        );
    }

}