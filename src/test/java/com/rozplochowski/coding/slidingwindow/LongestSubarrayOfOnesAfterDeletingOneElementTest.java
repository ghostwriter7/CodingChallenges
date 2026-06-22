package com.rozplochowski.coding.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubarrayOfOnesAfterDeletingOneElementTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnLongestSubarrayOfOnesAfterDeletingOneElement(int[] nums, int expected) {
        assertEquals(expected, LongestSubarrayOfOnesAfterDeletingOneElement.longestSubarray(nums));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1}, 3),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1}, 4),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                Arguments.of(new int[]{1, 1, 1}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, 18)
        );
    }

}