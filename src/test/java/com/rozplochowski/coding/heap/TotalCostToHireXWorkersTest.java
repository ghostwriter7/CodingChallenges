package com.rozplochowski.coding.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TotalCostToHireXWorkersTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeTotalCost(int[] cost, int k, int candidates, int expected) {
        var sut = new TotalCostToHireXWorkers();
        var actual = sut.totalCost(cost, k, candidates);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4, 11),
                Arguments.of(new int[]{1,2,4,1}, 3, 3, 4),
                Arguments.of(new int[]{18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75}, 13, 23, 223),
                Arguments.of(new int[]{17,12,2,200,8}, 1, 3, 2),
                Arguments.of(new int[]{100,48,6,73,4}, 3, 2, 58),
                Arguments.of(new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2, 423),
                Arguments.of(new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12, 1407),
                Arguments.of(new int[]{50,80,34,9,86,20,67,94,65,82,40,79,74,92,84,37,19,16,85,20,79,25,89,55,67,84,3,79,38,16,44,2,54,58}, 7, 12, 95)
        );
    }

}