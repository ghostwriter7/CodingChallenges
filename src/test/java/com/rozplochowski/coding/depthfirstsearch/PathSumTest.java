package com.rozplochowski.coding.depthfirstsearch;

import com.rozplochowski.coding.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldCOmputeNumberOfPathSums(int expected, Integer[] tree, int targetSum) {
        assertEquals(expected, PathSum.pathSum(TreeNode.of(tree), targetSum));
    }


    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(3, new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22),
                Arguments.of(3, new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 8),
                Arguments.of(0, new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}, 0)
        );
    }

}