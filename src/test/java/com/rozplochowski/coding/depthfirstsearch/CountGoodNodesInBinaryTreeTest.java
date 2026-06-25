package com.rozplochowski.coding.depthfirstsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountGoodNodesInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeCountGoodNodes(TreeNode root, int expected) {
        assertEquals(expected, CountGoodNodesInBinaryTree.goodNodes(root));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5))), 4)
        );
    }

}