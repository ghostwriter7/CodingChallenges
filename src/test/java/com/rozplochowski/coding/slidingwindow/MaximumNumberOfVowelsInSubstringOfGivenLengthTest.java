package com.rozplochowski.coding.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfVowelsInSubstringOfGivenLengthTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testMaxVowels(String input, int k, int expected) {
        assertEquals(expected, MaximumNumberOfVowelsInSubstringOfGivenLength.maxVowels(input, k));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("abciiidef", 3, 3),
                Arguments.of("aeiou", 2, 2),
                Arguments.of("leetcode", 3, 2)
        );
    }

}