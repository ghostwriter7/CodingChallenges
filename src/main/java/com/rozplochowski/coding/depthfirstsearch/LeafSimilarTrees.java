package com.rozplochowski.coding.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return findLeafs(new ArrayList<>(), root1).equals(findLeafs(new ArrayList<>(), root2));
    }

    private static List<Integer> findLeafs(List<Integer> leafs, TreeNode node) {
        if (node == null) return leafs;

        if (node.left == null && node.right == null) leafs.add(node.val);
        else {
            findLeafs(leafs, node.left);
            findLeafs(leafs, node.right);
        }
        return leafs;
    }
}
