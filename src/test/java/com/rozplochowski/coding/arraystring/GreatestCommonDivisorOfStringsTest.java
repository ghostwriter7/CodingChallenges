package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorOfStringsTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldComputeGCD(String str1, String str2, String expected) {
        var actual = new GreatestCommonDivisorOfStrings().compute(str1, str2);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abc", "abc", "abc"),
                Arguments.of("abc", "def", ""),
                Arguments.of("abc", "abcd", ""),
                Arguments.of("aaaa", "aa", "aa"),
                Arguments.of("ababab", "ab", "ab"),
                Arguments.of("xyzxyz", "xyzxyzxyz", "xyz"),
                Arguments.of("ABABAB", "ABAB", "AB")
        );
    }
}