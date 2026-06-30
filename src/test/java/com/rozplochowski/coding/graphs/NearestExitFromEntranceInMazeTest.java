package com.rozplochowski.coding.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NearestExitFromEntranceInMazeTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindNearestExit(char[][] maze, int[] entrance, int expectedSteps) {
        var nearestExitFromEntranceInMaze = new NearestExitFromEntranceInMaze();
        var actualSteps = nearestExitFromEntranceInMaze.nearestExit(maze, entrance);
        assertEquals(expectedSteps, actualSteps);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
//                Arguments.of(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}, 1),
                Arguments.of(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}, 2),
//                Arguments.of(new char[][]{{'.', '+'}}, new int[]{0, 0}, -1),
                Arguments.of(new char[][]{{'.', '.'}}, new int[]{0, 1}, 1),
                Arguments.of(new char[][]{{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','+','.','+'},{'+','+','+','+','+','.','+'}}, new int[]{0, 1}, 12),
                Arguments.of(new char[][]{{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}}, new int[]{0, 1}, 7)
        );
    }

}