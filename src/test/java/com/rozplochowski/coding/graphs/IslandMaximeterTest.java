package com.rozplochowski.coding.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IslandMaximeterTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindLargestIslandSize(int[][] grid, int expected) {
        assertEquals(expected, IslandMaximeter.maxIslandSize(grid));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 0, 1, 0},
                                {1, 1, 0, 0, 1},
                                {0, 0, 1, 0, 0},
                                {0, 0, 0, 1, 1}
                        }, 4
                ),
                Arguments.of(
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0}
                        }, 0
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 1},
                                {1, 1, 1}
                        }, 9
                ),
                Arguments.of(
                        new int[][]{
                                {0, 1, 0, 1, 0},
                                {0, 1, 1, 1, 0},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1}
                        }, 10
                )
        );
    }
}