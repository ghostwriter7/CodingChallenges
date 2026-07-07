package com.rozplochowski.coding.depthfirstsearch;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> deps = new ArrayList<>();

        for (var i = 0; i < numCourses; i++) {
            deps.add(new ArrayList<>());
        }

        for (var edge : prerequisites) {
            deps.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];

        for (var i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, deps)) return false;
        }

        return true;
    }

    private boolean hasCycle(int current, int[] state, List<List<Integer>> deps) {
        if (state[current] == 1) return true;
        if (state[current] == 2) return false;

        state[current] = 1;

        for (var dep : deps.get(current)) {
            if (hasCycle(dep, state, deps)) return true;
        }

        state[current] = 2;
        return false;
    }
}
