package com.rozplochowski.coding.graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static com.rozplochowski.coding.graphs.GraphMirror.Node;

class GraphMirrorTest {

    @ParameterizedTest
    @MethodSource("cases")
    void testCloneGraph(Node node, Node expected) {
        var clone = GraphMirror.cloneGraph(node);
        assertGraphEquals(expected, clone, new IdentityHashMap<>());
        assertNoSharedNodes(expected, clone, new IdentityHashMap<>());
    }

    private static Stream<Arguments> cases() {
        var root = new Node(1, new Node(2));
        var leaf = new Node(3, root);
        root.neighbors.getFirst().neighbors.add(leaf);

        var root2 = new Node(1, new Node(2));
        var leaf2 = new Node(3, root2);
        root2.neighbors.getFirst().neighbors.add(leaf2);


        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new Node(1), new Node(1)),
                Arguments.of(
                        new Node(1, new Node(2)),
                        new Node(1, new Node(2))
                ),
                Arguments.of(
                        new Node(1, new Node(2, new Node(3))),
                        new Node(1, new Node(2, new Node(3)))
                ),
                Arguments.of(root, root2)
        );
    }

    private static void assertGraphEquals(Node expected, Node actual, Map<Node, Node> visited) {
        if (expected == null || actual == null) {
            assertSame(expected, actual);
            return;
        }

        var alreadyMatched = visited.get(expected);
        if (alreadyMatched != null) {
            assertSame(alreadyMatched, actual);
            return;
        }

        visited.put(expected, actual);

        assertEquals(expected.val, actual.val);
        assertEquals(expected.neighbors.size(), actual.neighbors.size());

        for (var i = 0; i < expected.neighbors.size(); i++) {
            assertGraphEquals(expected.neighbors.get(i), actual.neighbors.get(i), visited);
        }
    }

    private static void assertNoSharedNodes(Node original, Node clone, Map<Node, Node> visited) {
        if (original == null || clone == null) return;

        var alreadyChecked = visited.get(original);
        if (alreadyChecked != null) {
            assertSame(alreadyChecked, clone);
            return;
        }

        visited.put(original, clone);

        assertNotSame(original, clone);

        for (var i = 0; i < original.neighbors.size(); i++) {
            assertNoSharedNodes(original.neighbors.get(i), clone.neighbors.get(i), visited);
        }
    }


}