package com.rozplochowski.coding.depthfirstsearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LeafSimilarTreesTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldComputeLeafSimilarTrees(TreeNode tree1, TreeNode tree2, boolean expected) {
        assertEquals(expected, LeafSimilarTrees.leafSimilar(tree1, tree2));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(null, null, true),
                Arguments.of(null, new TreeNode(1), false),
                Arguments.of(new TreeNode(1), null, false),
                Arguments.of(new TreeNode(1), new TreeNode(1), true),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(3), new TreeNode(2)), false),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(4)), false)
        );
    }
}