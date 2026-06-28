package com.rozplochowski.coding.binarysearchtree;

import com.rozplochowski.coding.TreeNode;
import com.sun.source.tree.Tree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeInBSTTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldDeleteNode(Integer[] root, int key, Integer[] expected) {
        TreeNode actual = new DeleteNodeInBST().deleteNode(TreeNode.of(root), key);
        TreeNode expectedTree = TreeNode.of(expected);
        assertEquals(expectedTree == null ? List.of() : expectedTree.toList(), actual == null ? List.of() : actual.toList());
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 3, new Integer[]{5, 4, 6, 2, null, null, 7}),
                Arguments.of(new Integer[]{5, 3, 6, 2, 4, null, 7}, 0, new Integer[]{5, 3, 6, 2, 4, null, 7}),
                Arguments.of(new Integer[]{}, 7, new Integer[]{}),
                Arguments.of(new Integer[]{0}, 0, new Integer[]{}),
                Arguments.of(new Integer[]{5,3,6,2,4,null,7}, 5, new Integer[]{6,3,7,2,4,})
        );
    }

}