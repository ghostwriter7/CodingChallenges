package com.rozplochowski.coding.dynamicprogramming;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public class MinimumCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        var n = cost.length;
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];

        for (var i = n - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
