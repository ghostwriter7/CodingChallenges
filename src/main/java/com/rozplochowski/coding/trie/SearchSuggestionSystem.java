package com.rozplochowski.coding.trie;

import java.util.*;

public class SearchSuggestionSystem {


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var root = new Node();

        Arrays.sort(products);

        for (var i = 0; i < products.length; i++) {
            var product = products[i];
            var current = root;
            for (var letter : product.toCharArray()) {
                var index = letter - 'a';
                var node = current.children[index];
                if (node == null) {
                    node = new Node();
                    current.children[index] = node;
                }
                current = node;
                if (current.size < 3)
                    current.add(i);
            }
        }

        List<List<String>> suggestions = new ArrayList<>(searchWord.length());

        var prev = root;
        for (var i = 0; i < searchWord.length(); i++) {
            if (prev == null) {
                suggestions.add(List.of());
                continue;
            }

            var letter = searchWord.charAt(i);
            var index = letter - 'a';
            prev = prev.children[index];

            if (prev == null || prev.size == 0) {
                suggestions.add(List.of());
                continue;
            }

            List<String> top3 = new ArrayList<>();
            for (var j = 0; j < prev.size; j++) {
                top3.add(products[prev.products[j]]);
            }
            suggestions.add(top3);
        }

        return suggestions;
    }


    private static class Node {
        private final int[] products = new int[]{-1, -1, -1};
        private int size = 0;
        private final Node[] children;

        private Node() {
            children = new Node[26];
        }

        private void add(int index) {
            products[size++] = index;
        }
    }
}
