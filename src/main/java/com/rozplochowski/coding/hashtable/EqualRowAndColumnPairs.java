package com.rozplochowski.coding.hashtable;

import java.util.*;

/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * <p>
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
public class EqualRowAndColumnPairs {

    public static int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rowCount = new HashMap<>();
        var n = grid.length;

        for (var row : grid) {
            List<Integer> l = new ArrayList<>(n);
            for (var cell : row) {
                l.add(cell);
            }
            rowCount.merge(l, 1, Integer::sum);
        }

        int pairs = 0;
        List<Integer> placeholder = new ArrayList<>(n);

        for (var i = 0; i < grid.length; i++) {
            placeholder.clear();

            for (var row : grid) {
                placeholder.add(row[i]);
            }

            pairs += rowCount.getOrDefault(placeholder, 0);
        }

        return pairs;
    }

}
