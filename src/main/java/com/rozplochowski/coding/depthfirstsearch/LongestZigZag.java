package com.rozplochowski.coding.depthfirstsearch;

/**
 * You are given the root of a binary tree.
 * <p>
 * A ZigZag path for a binary tree is defined as follow:
 * <p>
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * <p>
 * Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZag {
    private int best = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return best;
    }

    private State dfs(TreeNode node) {
        if (node == null) return new State(0, 0);

        State left = dfs(node.left);
        State right = dfs(node.right);

        int leftLength = node.left == null ? 0 : left.right + 1;
        int rightLength = node.right == null ? 0 : right.left + 1;

        best = Math.max(Math.max(leftLength, rightLength), best);

        return new State(leftLength, rightLength);
    }

    public class State {
        int left;
        int right;

        State(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
