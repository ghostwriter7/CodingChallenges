package com.rozplochowski.coding.graphs;

import java.util.*;

public class IslandCount {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Given an `m x n` grid of characters where '1' represents land and '0' represents water,
     * count how many distinct islands exist.
     * Two land cells are part of the same island iff they are 4-directionally adjacent.
     */
    public static int count(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        var rows = grid.length;
        var cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        var count = 0;

        for (var i = 0; i < rows; i++) {
            var row = grid[i];

            for (var j = 0; j < cols; j++) {

                if (row[j] == 1 && !visited[i][j]) {
                    count++;
                    markIslandAsVisited(grid, visited, j, i);
                }
            }
        }

        return count;
    }

    private static void markIslandAsVisited(int[][] grid, boolean[][] visited, int col, int row) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        var rows = grid.length;
        var cols = grid[0].length;

        while (!queue.isEmpty()) {
            var current = queue.poll();
            var x = current[0];
            var y = current[1];

            for (var direction : DIRECTIONS) {
                var nextX = x + direction[0];
                var nextY = y + direction[1];

                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) continue;

                if (visited[nextX][nextY]) continue;

                var cell = grid[nextX][nextY];
                if (cell == 1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }

            }
        }
    }

}
