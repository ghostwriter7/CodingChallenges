package com.rozplochowski.coding.slidingwindow;

/**
 * Given a binary array nums, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        var left = 0;
        var zeroCount = 0;
        var max = 0;

        for (var right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > 1) {
                var l = nums[left];
                if (l == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}
