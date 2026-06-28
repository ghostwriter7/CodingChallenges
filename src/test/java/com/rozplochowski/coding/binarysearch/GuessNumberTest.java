package com.rozplochowski.coding.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldGuessNumber(int n, int expected) {
        assertEquals(expected, new GuessNumber(expected).guessNumber(n));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(10, 6),
                Arguments.of(1, 1),
                Arguments.of(2, 1)
        );
    }

}