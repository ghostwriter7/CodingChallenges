package com.rozplochowski.coding.breadthfirstsearch;

import com.rozplochowski.coding.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * <p>
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSumOfBinaryTree {

    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int answer = 1;
        int sum = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        var level = 1;
        while (!queue.isEmpty()) {
            var size = queue.size();

            var currentSum = 0;
            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                currentSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (currentSum > sum) {
                answer = level;
                sum = currentSum;
            }

            level++;
        }

        return answer;
    }
}
