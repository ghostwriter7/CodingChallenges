package com.rozplochowski.coding.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTreeTest {

    @Test
    void shouldWork() {
        var trie = new PrefixTree();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

}