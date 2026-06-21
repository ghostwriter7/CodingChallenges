package com.rozplochowski.coding.arraystring;

/**
 * Given an integer array nums,
 * return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        var first = Integer.MAX_VALUE;
        var second = Integer.MAX_VALUE;

        for (var num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
