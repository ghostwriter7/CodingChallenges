package com.rozplochowski.coding.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testContainerWithMostWater(int[] height, int expected) {
        assertEquals(expected, new ContainerWithMostWater().maxArea(height));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }

}