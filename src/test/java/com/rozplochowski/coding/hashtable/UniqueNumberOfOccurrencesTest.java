package com.rozplochowski.coding.hashtable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniqueNumberOfOccurrencesTest {
    @ParameterizedTest
    @MethodSource("parameters")
    void testUniqueNumberOfOccurrences(int[] input, boolean expected) {
        assertEquals(expected, UniqueNumberOfOccurrences.uniqueOccurrences(input));
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3}, true),
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3, 4}, false),
                Arguments.of(new int[]{-3,0,1,-3,1,1,1,-3,10,0}, true),
                Arguments.of(new int[]{1,2}, false)
        );
    }



}