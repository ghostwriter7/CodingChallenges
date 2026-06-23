package com.rozplochowski.coding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemovingStarsFromStringTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldRemoveStars(String input, String expected) {
        assertEquals(expected, RemovingStarsFromString.removeStars(input));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("leet**cod*e", "lecoe"),
                Arguments.of("erase*****", "")
        );
    }
}