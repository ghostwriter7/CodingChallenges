package com.rozplochowski.coding.prefixsum;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

       var sumLeft = new int[nums.length];
       for (var i = 1; i < nums.length; i++) {
           sumLeft[i] += sumLeft[i - 1] + nums[i - 1];
       }

       var sumRight = new int[nums.length];
       for (var i = nums.length - 2; i >= 0; i--) {
           sumRight[i] += sumRight[i + 1] + nums[i + 1];
       }

       for (var i = 0; i < nums.length; i++) {
           if (sumLeft[i] == sumRight[i]) return i;
       }

        return -1;
    }
}
