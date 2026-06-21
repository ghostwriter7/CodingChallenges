package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingTripletSubsequenceTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldComputeIncreasingTripletSubsequence(int[] input, boolean expected) {
        var actual = new IncreasingTripletSubsequence().increasingTriplet(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
                Arguments.of(new int[]{2, 1, 5, 0, 4, 6}, true),
                Arguments.of(new int[]{1, 2, 0, 1}, false)
        );
    }

}