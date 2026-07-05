package com.rozplochowski.coding.graphs;


import java.util.*;

public final class GraphMirror {
    /**
     * You are given a reference to a node in an undirected graph.
     * Each node has an integer `val` and a list `neighbors`.
     * Deep-copy the entire graph and return the reference to the cloned start node.
     * No node-vals are guaranteed unique, so identity must be preserved by structure, not value.
     */
    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> originalToClone = new IdentityHashMap<>();

        return clone(node, originalToClone);
    }

    private static Node clone(Node node, Map<Node, Node> originalToClone) {
        if (originalToClone.containsKey(node)) return originalToClone.get(node);

        var clone = new Node(node.val);
        originalToClone.put(node, clone);

        for (var neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor, originalToClone));
        }

        return clone;
    }


    public static class Node {
        public final int val;
        public final List<Node> neighbors = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node... neighbors) {
            this.val = val;
            this.neighbors.addAll(List.of(neighbors));
        }
    }
}
