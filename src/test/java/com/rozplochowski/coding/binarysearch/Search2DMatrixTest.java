package com.rozplochowski.coding.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Search2DMatrixTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindValue(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, Search2DMatrix.searchMatrix(matrix, target));
    }


    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3, true),
                Arguments.of(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 13, false)
        );
    }
}