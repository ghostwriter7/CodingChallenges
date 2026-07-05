package com.rozplochowski.coding.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandMaximeter {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Using the same land/water grid definition as in IslandCount,
     * compute the maximum island size, measured as the number of land cells in the largest 4-directionally adjacent island.
     */
    public static int maxIslandSize(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        var rows = grid.length;
        var cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        var max = 0;

        for (var row = 0; row < rows; row++) {

            for (var col = 0; col < cols; col++) {

                if (grid[row][col] == 1 && !visited[row][col]) {
                    var size = measureIsland(grid, visited, row, col);
                    max = Math.max(max, size);
                }

            }
        }

        return max;
    }

    private static int measureIsland(int[][] grid, boolean[][] visited, int row, int col) {
        var size = 1;
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

                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || visited[nextX][nextY]) continue;

                var cell = grid[nextX][nextY];
                if (cell == 1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    size++;
                }

            }
        }

        return size;
    }
}
