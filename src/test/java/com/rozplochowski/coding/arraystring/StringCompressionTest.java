package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void testStringCompression(char[] input, int expected) {
        assertEquals(expected, StringCompression.compress(input));
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, 6),
                Arguments.of(new char[]{'a'}, 1),
                Arguments.of(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, 4),
                Arguments.of(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}, 6),
                Arguments.of(new char[]{'a', 'b', 'c'}, 3),
                Arguments.of(new char[]{'a', 'a', 'a', 'a', 'a', 'b'}, 3)
        );
    }
}