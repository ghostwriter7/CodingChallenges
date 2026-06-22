package com.rozplochowski.coding.hashtable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindDifferenceOfTwoArraysTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeDifferenceOfTwoArrays(int[] nums1, int[] nums2, List<List<Integer>> expected) {
        List<List<Integer>> actual = FindDifferenceOfTwoArrays.findDifference(nums1, nums2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6}, List.of(List.of(1, 3), List.of(4, 6))),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8, 10}, List.of(List.of(1, 3, 5), List.of(6, 8, 10))),
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}, List.of(List.of(3), List.of()))
        );
    }

}