package com.rozplochowski.coding.depthfirstsearch;

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
        var root = buildTree(tree);
        var actual = PathSum.pathSum(root, targetSum);
        assertEquals(expected, actual);
    }

    private TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(3, new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22),
                Arguments.of(3, new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 8),
                Arguments.of(0, new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}, 0)
        );
    }

}