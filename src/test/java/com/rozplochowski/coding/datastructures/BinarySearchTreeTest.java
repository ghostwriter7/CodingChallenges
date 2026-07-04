package com.rozplochowski.coding.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
}
