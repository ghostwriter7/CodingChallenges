package com.rozplochowski.coding.depthfirstsearch;

import com.rozplochowski.coding.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthOfBinaryTreeTest {

    @Test
    void shouldComputeMaxDepthOfBinaryTree() {
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(12);

        assertEquals(4, MaxDepthOfBinaryTree.maxDepth(root));
    }

}