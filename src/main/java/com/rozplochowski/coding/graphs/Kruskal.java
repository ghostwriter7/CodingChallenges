package com.rozplochowski.coding.graphs;

import java.util.*;

public class Kruskal {

    public static List<Edge> minSpanningTree(List<List<Edge>> adjList) {
        if (adjList == null || adjList.isEmpty()) return List.of();

        List<Edge> edges = new ArrayList<>();
        for (var list : adjList) {
            edges.addAll(list);
        }

        edges.sort(Comparator.comparingInt(Edge::weight));

        List<Edge> minSpanningTree = new ArrayList<>();

        UnionFind unionFind = new UnionFind(adjList.size());
        var targetSize = adjList.size() - 1;

        for (var edge : edges) {
            if (unionFind.union(edge.from, edge.to)) {
                minSpanningTree.add(edge);

                if (minSpanningTree.size() == targetSize) break;
            }
        }

        if (minSpanningTree.size() != targetSize) {
            throw new IllegalArgumentException("Graph is not connected; no spanning tree exists");
        }

        return minSpanningTree;
    }

    private static class UnionFind {
        private final int[] parents;
        private final int[] ranks;


        private UnionFind(int size) {
            parents = new int[size];
            ranks = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        private int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }

        private boolean union(int i, int j) {
            var parentI = find(i);
            var parentJ = find(j);

            if (parentI == parentJ) return false;

            if (ranks[parentI] < ranks[parentJ]) {
                parents[parentI] = parentJ;
            } else if (ranks[parentI] > ranks[parentJ]) {
                parents[parentJ] = parentI;
            } else {
                parents[parentJ] = parentI;
                ranks[parentI]++;
            }

            return true;
        }

    }

    public record Edge(int from, int to, int weight){}
}
