package com.rozplochowski.coding.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testIsSubsequence(String s, String t, boolean expected) {
        var actual = IsSubsequence.isSubsequence(s, t);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false)
        );
    }

}