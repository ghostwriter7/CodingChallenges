package com.rozplochowski.coding.graphs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IslandCountTest {


    @ParameterizedTest
    @MethodSource("cases")
    void shouldCountIslands(int[][] grid, int expected) {
        assertEquals(expected, IslandCount.count(grid));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 0, 1, 0},
                                {1, 1, 0, 0, 1},
                                {0, 0, 1, 0, 0},
                                {0, 0, 0, 1, 1}
                        }, 5
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
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                        }, 1
                ),
                Arguments.of(
                        new int[][]{
                                {1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1},
                        }, 1
                ),
                Arguments.of(
                        new int[][]{
                                {0, 1, 0, 1, 0},
                                {1, 0, 1, 0, 1},
                                {0, 1, 0, 1, 0},
                        }, 7
                )
        );
    }
}