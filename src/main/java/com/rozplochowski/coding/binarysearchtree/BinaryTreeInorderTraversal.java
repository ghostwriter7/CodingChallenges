package com.rozplochowski.coding.binarysearchtree;

import com.rozplochowski.coding.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;

        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}
