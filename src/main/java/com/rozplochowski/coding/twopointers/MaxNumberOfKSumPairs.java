package com.rozplochowski.coding.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * <p>
 * Return the maximum number of operations you can perform on the array.
 */
public class MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        int ops = 0;

        Map<Integer, Integer> seenCount = new HashMap<>();

        for (var num : nums) {
            var complement = k - num;

            var count = seenCount.getOrDefault(complement, 0);
            if (count >= 1) {
                ops++;
                seenCount.put(complement, count - 1);
            } else {
                seenCount.merge(num, 1, Integer::sum);
            }
        }

        return ops;
    }

    public static int maxOperations2(int[] nums, int k) {

        Arrays.sort(nums);

        int ops = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            var sum = nums[left] + nums[right];
            if (sum == k) {
                ops++;
                left++;
                right--;
            } else if (sum < k) left++;
            else right--;
        }

        return ops;
    }
}
