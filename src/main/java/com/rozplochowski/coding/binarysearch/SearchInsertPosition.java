package com.rozplochowski.coding.binarysearch;

public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        var lo = 0;
        var hi = nums.length - 1;

        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var current = nums[mid];
            if (current == target) return mid;
            else if (current < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }
}
