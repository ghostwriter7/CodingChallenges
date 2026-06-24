package com.rozplochowski.coding.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Dota2SenateTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldPredictVictory(String senate, String expected) {
        String actual = Dota2Senate.predictPartyVictory(senate);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("RD", "Radiant"),
                Arguments.of("RDD", "Dire"),
                Arguments.of("DRD", "Dire")
        );
    }
}