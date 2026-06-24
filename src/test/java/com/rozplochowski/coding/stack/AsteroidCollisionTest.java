package com.rozplochowski.coding.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeCollision(int[] asteroids, int[] expected) {
        assertArrayEquals(expected, AsteroidCollision.asteroidCollision(asteroids));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
                Arguments.of(new int[]{8, -8}, new int[]{}),
                Arguments.of(new int[]{10, 2, -5}, new int[]{10}),
                Arguments.of(new int[]{3, 5, -6, 2, -1, 4}, new int[]{-6, 2, 4}),
                Arguments.of(new int[]{3, -69, -65, 67, -76, 34, 10, 96, 55, 77, 85, 56, 99, -1, 6, -37, -7, -70, 75, -60, 4, -73, 35, -32, 3, -7, 72, 83, -82, 70, 68, 63, 33, -68, -100, 61, -96, 27, 89, 81, -11, -63, 69, 49, -34, 23, 87, 23, 26, -67, 67, -100, -84, -89, -76, -42, -86, -96, 86, 7, 25, 9, -17, 7, -15, -35, -65, -82, -32, 90, -27, 39, 30, -42, -3, -71, -46, 24, 20, -84, 8, 51, -84, 24, 53, 66, 87, -64, 27, -5, -68, 86, -49, -53, 68, 21, -88, 58, 21, -18}, new int[]{-69, -65, -76, -100, -96, -100, -84, -89, -76, -42, -86, -96, 86, 90, 58, 21})

        );
    }

}