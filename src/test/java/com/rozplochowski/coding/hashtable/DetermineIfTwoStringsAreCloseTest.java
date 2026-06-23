package com.rozplochowski.coding.hashtable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DetermineIfTwoStringsAreCloseTest {

    @ParameterizedTest
    @MethodSource("values")
    void testCloseStrings(String word1, String word2, boolean expected) {
        DetermineIfTwoStringsAreClose solution = new DetermineIfTwoStringsAreClose();
        boolean actual = solution.closeStrings(word1, word2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of("abc", "bca", true),
                Arguments.of("a", "aa", false),
                Arguments.of("cabbba", "abbccc", true)
        );
    }

}