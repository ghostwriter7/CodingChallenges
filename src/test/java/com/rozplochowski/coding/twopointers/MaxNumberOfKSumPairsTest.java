package com.rozplochowski.coding.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberOfKSumPairsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testMaxNumberOfKSumPairs(int[] nums, int k, int expected) {
        assertEquals(expected, MaxNumberOfKSumPairs.maxOperations(nums, k));
    }


    @ParameterizedTest
    @MethodSource("cases")
    void testMaxNumberOfKSumPairs2(int[] nums, int k, int expected) {
        assertEquals(expected, MaxNumberOfKSumPairs.maxOperations2(nums, k));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 5, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 3}, 6, 1)
        );
    }


}