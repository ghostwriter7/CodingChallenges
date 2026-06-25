package com.rozplochowski.coding.depthfirstsearch;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 */
public class CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + count(root.left, root.val) + count(root.right, root.val);
    }

    private static int count(TreeNode node, int max) {
        if (node == null) return 0;

        max = Math.max(max, node.val);

        return (node.val >= max ? 1 : 0) + count(node.left, max) + count(node.right, max);
    }
}
