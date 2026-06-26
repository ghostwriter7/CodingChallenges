package com.rozplochowski.coding.depthfirstsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestZigZagTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeLongestZigZag(int expected, Integer[] tree) {
        assertEquals(expected, new LongestZigZag().longestZigZag(TreeNode.of(tree)));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(3, new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1}),
                Arguments.of(4, new Integer[]{1,1,1,null,1,null,null,1,1,null,1}),
                Arguments.of(0, new Integer[]{1}),
                Arguments.of(5, new Integer[]{7,null,4,10,6,9,10,7,5,3,3,null,null,7,2,9,8,null,null,3,3,2,1,2,1,10,10,5,2,null,7,7,null,9,6,10,8,null,9,null,null,null,5,4,null,6,5,null,null,5,6,null,null,6,6,null,null,null,null,3,9,null,null,null,null,null,null,null,8,null,4,null,null,null,null,null,5,null,10,8,5,null,null,null,null,10,null,null,null,null,null,null,null,7,null,null,6})
        );
    }

}