package com.rozplochowski.coding.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnMaxAmountOfMoneyRobbed(int[] nums, int expected) {
        int actual = HouseRobber.rob(nums);
        assertEquals(expected, actual);
    }

    private static Object[][] cases() {
        return new Object[][]{
                {new int[]{1,2,3,1}, 4},
                {new int[]{2,7,9,3,1}, 12},
                {new int[]{2,1,1,2}, 4},
                {new int[]{1}, 1},
                {new int[]{}, 0}
        };
    }

}