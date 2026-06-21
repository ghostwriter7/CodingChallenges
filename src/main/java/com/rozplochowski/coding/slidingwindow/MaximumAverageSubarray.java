package com.rozplochowski.coding.slidingwindow;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return nums[0];

        long sum = 0;
        for (var i = 0; i < k; i++) {
            sum += nums[i];
        }

        var max = sum;

        for (var i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }

}
