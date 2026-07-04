package com.rozplochowski.coding.datastructures;

import java.util.function.Consumer;

/**
 * In a binary search tree, each node on the left of the current node is smaller than the current node,
 * and each node on the right of the current node is larger than the current node.
 * <p>
 * If this rule is violated, the tree is not a binary search tree (just a binary tree).
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
