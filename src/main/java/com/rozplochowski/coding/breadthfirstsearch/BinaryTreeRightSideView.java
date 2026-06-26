package com.rozplochowski.coding.breadthfirstsearch;


import com.rozplochowski.coding.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    // Breadth-first search
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) queue.offer(root.left);
        if (root.right != null) queue.offer(root.right);

        while (!queue.isEmpty()) {
            var size = queue.size();
            TreeNode node = null;

            for (var i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(node.val);
        }

        return result;
    }

    // Depth-first search
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null) return;

        if (result.size() == depth) result.add(node.val);

        dfs(node.right, result, depth + 1);
        dfs(node.left, result, depth + 1);
    }
}
