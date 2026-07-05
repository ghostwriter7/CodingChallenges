package com.rozplochowski.coding.graphs;

import java.util.*;

public class PrimsSpanningTree {

    public static List<Edge> findSpanningTree(List<List<Edge>> adjList) {
        if (adjList == null || adjList.isEmpty()) return List.of();

        List<Edge> minSpanningTree = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));

        edges.addAll(adjList.getFirst());
        visited.add(0);

        while (!edges.isEmpty() && minSpanningTree.size() < adjList.size() - 1) {

            Edge minEdge = edges.poll();

            if (visited.contains(minEdge.to)) continue;

            minSpanningTree.add(minEdge);
            visited.add(minEdge.to);

            edges.addAll(adjList.get(minEdge.to));
        }

        if (minSpanningTree.size() != adjList.size() - 1) {
            throw new IllegalArgumentException("Graph is not connected; no spanning tree exists");
        }

        return minSpanningTree;
    }

    public record Edge(int from, int to, int weight) {
    }

}
