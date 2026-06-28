package com.rozplochowski.coding.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfProvincesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeNumberOfProvinces(int[][] graph, int expected) {
        assertEquals(expected, new NumberOfProvinces().findCircleNum(graph));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3)
        );
    }

}