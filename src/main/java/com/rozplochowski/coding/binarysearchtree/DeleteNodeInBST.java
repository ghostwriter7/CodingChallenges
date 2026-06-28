package com.rozplochowski.coding.binarysearchtree;

import com.rozplochowski.coding.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        Pair pair = findParentAndNode(null, root, key);
        if (pair.target() == null) return root;

        var t = pair.target();
        var p = pair.parent();

        if (t.left != null && t.right != null) {
            Pair successor = findMin(t, t.right);
            var value = successor.target().val;
            deleteNode(successor.parent(), value);
            t.val = value;
        } else {
            var c = t.left != null ? t.left : t.right;

            if (p != null) {
                if (p.left == t) p.left = c;
                else p.right = c;
                return root;
            } else return c;
        }

        return root;
    }

    private Pair findMin(TreeNode parent, TreeNode node) {
        while (node.left != null) {
            parent = node;
            node = node.left;
        }
        return new Pair(parent, node);
    }

    private Pair findParentAndNode(TreeNode parent, TreeNode node, int key) {
        if (node == null) return new Pair(null, null);

        if (node.val == key) return new Pair(parent, node);

        if (node.val > key) return findParentAndNode(node, node.left, key);
        return findParentAndNode(node, node.right, key);
    }

    record Pair(TreeNode parent, TreeNode target) {}
}
