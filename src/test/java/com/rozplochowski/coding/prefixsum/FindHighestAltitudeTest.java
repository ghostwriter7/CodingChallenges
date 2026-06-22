package com.rozplochowski.coding.prefixsum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindHighestAltitudeTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeHighestAltitude(int[] gain, int expected) {
        assertEquals(expected, FindHighestAltitude.largestAltitude(gain));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{-5, 1, 5, 0, -7}, 1),
                Arguments.of(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }

}