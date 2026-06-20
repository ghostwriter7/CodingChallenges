package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInStringTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldReverseWords(String s, String expected) {
        var actual = new ReverseWordsInString().reverseWords(s);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

}