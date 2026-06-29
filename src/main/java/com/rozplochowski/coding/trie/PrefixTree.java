package com.rozplochowski.coding.trie;

public class PrefixTree {
    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        var node = root;
        for (var letter : word.toCharArray()) {
            var index = letter - 'a';
            var child = node.children[index];
            if (child == null) {
                child = new Node();
                node.children[index] = child;
            }
            node = child;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        var node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String word) {
        var node = root;
        for (var letter : word.toCharArray()) {
            var index = letter - 'a';
            var child = node.children[index];
            if (child == null) return null;
            node = child;
        }
        return node;
    }

    private class Node {
        boolean isWord;
        Node[] children;

        Node() {
            children = new Node[26];
        }
    }
}
