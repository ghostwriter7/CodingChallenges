package com.rozplochowski.coding.breadthfirstsearch;

import com.rozplochowski.coding.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeRightSideViewTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnRightSideView(Integer[] tree, List<Integer> expected) {
        assertEquals(expected, BinaryTreeRightSideView.rightSideView(TreeNode.of(tree)));
    }

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnRightSideView2(Integer[] tree, List<Integer> expected) {
        assertEquals(expected, BinaryTreeRightSideView.rightSideView2(TreeNode.of(tree)));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new Integer[] {1,2,3,4,null,null,null,5}, List.of(1,3,4,5)),
                Arguments.of(new Integer[] {1,2,3,null,5,null,4}, List.of(1,3,4)),
                Arguments.of(new Integer[] {1,null,3}, List.of(1,3)),
                Arguments.of(new Integer[] {}, List.of())
        );
    }

}