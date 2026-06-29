package com.rozplochowski.coding.heap;

import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 * <p>
 * You are also given two integers k and candidates.
 * We want to hire exactly k workers according to the following rules:
 * <p>
 * You will run k sessions and hire exactly one worker in each session.
 * In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers.
 * Break the tie by the smallest index.
 * <p>
 * For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session,
 * we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
 * <p>
 * In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
 * If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
 * A worker can only be chosen once.
 * Return the total cost to hire exactly k workers.
 */
public class TotalCostToHireXWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> lQ = new PriorityQueue<>();
        PriorityQueue<Integer> rQ = new PriorityQueue<>();

        var l = 0;
        var r = costs.length - 1;

        while (l <= r && lQ.size() < candidates) {
            lQ.add(costs[l++]);
        }

        while (l <= r && rQ.size() < candidates) {
            rQ.add(costs[r--]);
        }

        long total = 0;
        while (k > 0) {
            if (rQ.isEmpty() || (!lQ.isEmpty() && lQ.peek() <= rQ.peek())) {
                total += lQ.poll();
                if (l <= r) lQ.add(costs[l++]);
            } else {
                total += rQ.poll();
                if (l <= r) rQ.add(costs[r--]);
            }
            k--;
        }
        return total;
    }
}
