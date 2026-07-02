package com.rozplochowski.coding.depthfirstsearch;

import com.rozplochowski.coding.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p.val, q.val);
    }

    private static TreeNode dfs(TreeNode node, int p, int q) {
        if (node == null) return null;
        if (node.val == p || node.val == q) return node;

        var l = dfs(node.left, p, q);
        var r = dfs(node.right, p, q);

        if (l != null && r != null) return node;
        return l != null ? l : r;
    }
}
