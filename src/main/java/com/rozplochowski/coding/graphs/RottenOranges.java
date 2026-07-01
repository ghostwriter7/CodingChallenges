package com.rozplochowski.coding.graphs;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottenOranges {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public int orangesRotting(int[][] grid) {

        var freshOranges = 0;

        Queue<int[]> rottenOranges = new ArrayDeque<>();

        for (int rIdx = 0; rIdx < grid.length; rIdx++) {
            var row = grid[rIdx];

            for (int cIdx = 0; cIdx < grid[rIdx].length; cIdx++) {
                var cell = row[cIdx];
                if (cell == ROTTEN) {
                    rottenOranges.add(new int[]{rIdx, cIdx});
                } else if (cell == FRESH) {
                    freshOranges++;
                }
            }

        }

        var rows = grid.length;
        var cols = grid[0].length;
        var minutes = 0;
        while (!rottenOranges.isEmpty() && freshOranges > 0) {
            var size = rottenOranges.size();

            for (var i = 0; i < size; i++) {
                var rottenOrange = rottenOranges.poll();

                for (var direction : DIRECTIONS) {
                    var nextX = rottenOrange[0] + direction[0];
                    var nextY = rottenOrange[1] + direction[1];

                    if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols) continue;

                    if (grid[nextX][nextY] == FRESH) {
                        grid[nextX][nextY] = ROTTEN;
                        freshOranges--;
                        rottenOranges.add(new int[]{nextX, nextY});
                    }

                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

//
//    public int orangesRotting(int[][] grid) {
//
//        var freshOranges = 0;
//        int[][] rottenOrangesAfterMinutes = new int[grid.length][grid[0].length];
//
//        for (int rIdx = 0; rIdx < grid.length; rIdx++) {
//            var row = grid[rIdx];
//
//            for (int cIdx = 0; cIdx < grid[rIdx].length; cIdx++) {
//                var cell = row[cIdx];
//                if (cell == ROTTEN) {
//                    dfs(rIdx, cIdx, grid, rottenOrangesAfterMinutes, 0);
//                } else if (cell == FRESH) {
//                    freshOranges++;
//                }
//            }
//
//        }
//
//        var min = 0;
//        var count = 0;
//        for (var row : rottenOrangesAfterMinutes) {
//            for (var cell : row) {
//                if (cell == 0) continue;
//                count++;
//                min = Math.max(min, cell);
//            }
//        }
//
//        return count == freshOranges ? min : -1;
//    }
//
//    private void dfs(int rIdx, int cIdx, int[][] grid, int[][] rottenOrangesAfterMinutes, int minutes) {
//
//        for (var direction : DIRECTIONS) {
//            var nextX = rIdx + direction[0];
//            var nextY = cIdx + direction[1];
//
//            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) continue;
//
//            var cell = grid[nextX][nextY];
//            if (cell == EMPTY || cell == ROTTEN) continue;
//
//            var currentAnswer = rottenOrangesAfterMinutes[nextX][nextY];
//            var nextMinutes = minutes +1;
//            if (currentAnswer != 0 && currentAnswer < nextMinutes) continue;
//
//            rottenOrangesAfterMinutes[nextX][nextY] = nextMinutes;
//            dfs(nextX, nextY, grid, rottenOrangesAfterMinutes, nextMinutes);
//        }
//
//    }
}
