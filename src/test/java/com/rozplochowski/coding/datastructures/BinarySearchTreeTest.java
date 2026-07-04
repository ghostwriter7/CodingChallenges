package com.rozplochowski.coding.datastructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void shouldDoPreOrderTraversal() {
        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> consumer = actual::add;

        var tree = BinarySearchTree.of(new int[] {1, 10, 5, 3, 16, 7, 9});

        tree.preOrder(consumer);

        assertEquals(List.of(1, 10, 5, 3, 7, 9, 16), actual);
    }

    @Test
    void shouldDoInOrderTraversal() {
        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> consumer = actual::add;

        var tree = BinarySearchTree.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9});

        tree.inOrder(consumer);

        assertEquals(List.of(-5, -3, 1, 3, 5, 7, 9, 10, 16), actual);
    }

    @Test
    void shouldDoPostOrderTraversal() {
        List<Integer> actual = new ArrayList<>();
        Consumer<Integer> consumer = actual::add;

        var tree = BinarySearchTree.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9});

        tree.postOrder(consumer);

        assertEquals(List.of(-5, -3, 3, 9, 7, 5, 16, 10, 1), actual);
    }

    @Test
    void shouldFindValue() {
        var tree = BinarySearchTree.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9});

        assertTrue(tree.search(16));
    }

    @Test
    void shouldNotFindValue() {
        var tree = BinarySearchTree.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9});

        assertFalse(tree.search(20));
    }

    @ParameterizedTest
    @MethodSource("deleteCases")
    void shouldDelete(int[] tree, boolean expected, int value) {
        var treeNode = BinarySearchTree.of(tree);
        var actual = treeNode.delete(value);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> deleteCases() {
        return Stream.of(
            Arguments.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9}, true, 1),
            Arguments.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9}, true, -5),
            Arguments.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9}, true, -3),
            Arguments.of(new int[] {1, -3, -5, -2, -4, -6, 10, 5, 3, 16, 7, 9}, true, -3),
            Arguments.of(new int[] {1, -3, -5, 10, 5, 3, 16, 7, 9}, false, 20)
        );
    }
}
