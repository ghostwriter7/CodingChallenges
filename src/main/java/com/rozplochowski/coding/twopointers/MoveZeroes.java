package com.rozplochowski.coding.twopointers;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        var writeAt = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeAt++] = nums[i];
            }
        }
        Arrays.fill(nums, writeAt, nums.length, 0);
    }
}
