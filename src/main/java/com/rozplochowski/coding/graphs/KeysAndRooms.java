package com.rozplochowski.coding.graphs;

import java.util.*;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        var count = 1;

        Queue<Integer> keys = new LinkedList<>(rooms.getFirst());

        while (!keys.isEmpty()) {
            var key = keys.poll();
            if (visited[key]) continue;
            visited[key] = true;
            keys.addAll(rooms.get(key));
            count++;
        }

        return count == rooms.size();
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        var count = 1;

        for (var key : rooms.getFirst()) {
            if (!visited[key]) {
                visited[key] = true;
                count += dfs(visited, rooms.get(key), rooms);
            }
        }

        return count == rooms.size();
    }

    private int dfs(boolean[] visited, List<Integer> keys, List<List<Integer>> rooms) {
        var count = 1;
        for (var key : keys) {
            if (!visited[key]) {
                visited[key] = true;
                count += dfs(visited, rooms.get(key), rooms);
            }
        }
        return count;
    }
}
