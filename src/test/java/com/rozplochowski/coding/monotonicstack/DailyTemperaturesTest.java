package com.rozplochowski.coding.monotonicstack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnCorrectAnswers(int[] temperatures, int[] expectedAnswers) {
        var actualAnswers = DailyTemperatures.dailyTemperatures(temperatures);
        assertArrayEquals(expectedAnswers, actualAnswers);
    }

    private static Object[][] cases() {
        return new Object[][]{
                {new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1,1,4,2,1,1,0,0}},
                {new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}},
                {new int[]{30, 60, 90}, new int[]{1, 1, 0}}
        };
    }

}