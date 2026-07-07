package com.rozplochowski.coding.depthfirstsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnTrueWhenNoCycleExists(int numOfCourses, int[][] prerequisites, boolean expected) {
        var sut = new CourseSchedule();
        var actual = sut.canFinish(numOfCourses, prerequisites);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1,0}}, true),
                Arguments.of(2, new int[][]{{1,0},{0,1}}, false),
                Arguments.of(3, new int[][]{{1,0},{1,2},{2,0}}, true),
                Arguments.of(3, new int[][]{{1,0},{2,0},{0,2}}, false),
                Arguments.of(4, new int[][]{{1,0},{1,2},{2,0},{0,1}}, false),
                Arguments.of(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}, true),
                Arguments.of(3, new int[][]{{1,0},{1,2},{0,1}}, false),
                Arguments.of(8, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}}, true)
        );
    }

}