package com.rozplochowski.coding.datastructures;

import java.util.function.Consumer;

/**
 * In a binary search tree, each node on the left of the current node is smaller than the current node,
 * and each node on the right of the current node is larger than the current node.
 * <p>
 * If this rule is violated, the tree is not a binary search tree (just a binary tree).
 * <p>
 * Search Time is O(LogN) in a well-balanced binary search tree.
 * If a tree is not well-balanced, the search time is O(h) where h is the height of the tree.
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public boolean search(int value) {
        return search(root, value);
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    /**
     * When a target node has only one child, then the link from its parent can be redirected to its grandchild.
     * When a target node has no children, then the link from its parent can be removed.
     * When a target node has two children, then we need to find the in-order predecessor or successor of the target node.
     * In-order predecessor is the largest node in the left subtree of the target node.
     * In-order successor is the smallest node in the right subtree of the target node.
     * Once we have the in-order predecessor or successor, we can replace the target node with it and remove the predecessor or successor.
     */
    public boolean delete(int value) {
        var pair = find(null, root, value);

        if (pair == null) return false;

        var parent = pair.parent();
        var child = pair.child();

        if (child.left != null && child.right != null) {
            Pair predecessorPair = predecessor(child, child.left);
            var predecessor = predecessorPair.child();
            var predecessorParent = predecessorPair.parent();

            child.value = predecessor.value;
            if (predecessorParent == child) {
                child.left = predecessor.left;
            } else {
                predecessorParent.right = predecessor.left;
            }
        } else {
            var grandChild = child.left != null ? child.left : child.right;
            if (parent == null) {
                root = grandChild;
            } else {
                if (parent.left == child) {
                    parent.left = grandChild;
                } else {
                    parent.right = grandChild;
                }
            }
        }

        return true;
    }

    private Pair predecessor(Node parent, Node node) {
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        return new Pair(parent, node);
    }

    private Pair find(Node parent, Node node, int value) {
        if (node == null) return null;

        if (node.value == value) return new Pair(parent, node);

        return node.value < value ? find(node, node.right, value) : find(node, node.left, value);
    }

    private void insert(Node node, int value) {
        var current = node.value;
        if (current < value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        }
    }

    public static BinarySearchTree of(int[] values) {
        var tree = new BinarySearchTree();
        for (var value : values) {
            tree.insert(value);
        }
        return tree;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        inOrder(value -> sb.append(value).append(" "));
        sb.append("]");
        return sb.toString();
    }


    private boolean search(Node node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return node.value < value ? search(node.right, value) : search(node.left, value);
    }

    public void preOrder(Consumer<Integer> consumer) {
        preOrder(root, consumer);
    }

    private void preOrder(Node node, Consumer<Integer> consumer) {
        if (node == null) return;

        consumer.accept(node.value);
        preOrder(node.left, consumer);
        preOrder(node.right, consumer);

    }

    /**
     * It produces numbers in ascending order.
     * Everything to the left is smaller than the current node, everything to the right is bigger than the current node.
     */
    public void inOrder(Consumer<Integer> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node node, Consumer<Integer> consumer) {
        if (node == null) return;

        inOrder(node.left, consumer);
        consumer.accept(node.value);
        inOrder(node.right, consumer);
    }

    public void postOrder(Consumer<Integer> consumer) {
        postOrder(root, consumer);
    }

    private void postOrder(Node node, Consumer<Integer> consumer) {
        if (node == null) return;

        postOrder(node.left, consumer);
        postOrder(node.right, consumer);
        consumer.accept(node.value);
    }

    private record Pair(Node parent, Node child) {
    }

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node(int value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
