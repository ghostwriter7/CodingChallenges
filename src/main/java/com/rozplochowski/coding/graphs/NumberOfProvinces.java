package com.rozplochowski.coding.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * There are n cities.
 * Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (var i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;

            count++;
            var connections = isConnected[i];
            dfs(isConnected, connections, visited);
        }

        return count;
    }

    private void dfs(int[][] isConnected, int[] connections, boolean[] visited) {
        for (var i = 0; i < connections.length; i++) {
            var noEdge = connections[i] == 0;
            if (noEdge || visited[i]) continue;
            visited[i] = true;
            dfs(isConnected, isConnected[i], visited);
        }
    }


}
