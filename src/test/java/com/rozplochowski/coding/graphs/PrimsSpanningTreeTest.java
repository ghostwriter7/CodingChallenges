package com.rozplochowski.coding.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.rozplochowski.coding.graphs.PrimsSpanningTree.Edge;

class PrimsSpanningTreeTest {

    @Test
    void shouldFindMinimumSpanningTree() {
        List<List<Edge>> adjacencyList = List.of(
                List.of(new Edge(0, 1, 9)),
                List.of(new Edge(1, 2, 1), new Edge(1, 3, 8)),
                List.of(new Edge(2, 1, 1), new Edge(2, 3, 8), new Edge(2, 4, 3)),
                List.of(new Edge(3, 1, 8), new Edge(3, 2, 8), new Edge(3, 5, 4)),
                List.of(new Edge(4, 2, 3), new Edge(4, 5, 1), new Edge(4, 6, 3)),
                List.of(new Edge(5, 3, 4), new Edge(5, 4, 1), new Edge(5, 6, 2)),
                List.of(new Edge(6, 4, 3), new Edge(6, 5, 2))
        );


        var result = PrimsSpanningTree.findSpanningTree(adjacencyList);

        assertEquals(20, result.stream().mapToInt(Edge::weight).sum());
    }

}