package com.rozplochowski.coding.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInArrayTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindKthLargestElement(int[] nums, int k, int expected) {
        assertEquals(expected, new KthLargestElementInArray().findKthLargest(nums, k));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }
}