package com.rozplochowski.coding.slidingwindow;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {

        var max = 0;
        var left = 0;
        var right = 0;
        var zeroCount = 0;

        while (right < nums.length) {
            var v = nums[right];

            if (v == 0) zeroCount++;

            while (zeroCount > k) {
                var l = nums[left];
                if (l == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
