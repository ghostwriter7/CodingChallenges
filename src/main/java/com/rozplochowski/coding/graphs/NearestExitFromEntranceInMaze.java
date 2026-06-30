package com.rozplochowski.coding.graphs;

import java.util.*;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * <p>
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze.
 * Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze.
 * The entrance does not count as an exit.
 * <p>
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;
        queue.offer(entrance);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;

        var lastRow = maze.length - 1;
        var lastCol = maze[0].length - 1;
        var directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                var x = node[0];
                var y = node[1];
                var cell = maze[x][y];

                if ((x == 0 || y == 0 || x == lastRow || y == lastCol) && cell == '.' && (x != entrance[0] || y != entrance[1])) {
                    return distance;
                }

                for (var direction : directions) {
                    var nextX = node[0] + direction[0];
                    var nextY = node[1] + direction[1];

                    if (nextX < 0 || nextX > lastRow || nextY < 0 || nextY > lastCol) continue;

                    if (maze[nextX][nextY] == '+') continue;

                    if (!visited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            distance++;
        }

        return -1;
    }
}

