package com.rozplochowski.coding.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldValidateParentheses(String input, boolean expected) {
        assertEquals(expected, ValidParentheses.isValid(input));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([)]", false),
                Arguments.of("{[]}", true),
                Arguments.of("([])", true)
        );
    }

}