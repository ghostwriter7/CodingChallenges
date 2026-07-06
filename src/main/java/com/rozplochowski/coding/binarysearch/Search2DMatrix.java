package com.rozplochowski.coding.binarysearch;

public class Search2DMatrix {

    /**
     * You are given an m x n integer matrix `matrix` with the following two properties:
     * <p>
     * Each row is sorted in non-decreasing order.
     * <p>
     * The first integer of each row is greater than the last integer of the previous row.
     * <p>
     * Given an integer target, return true if target is in matrix or false otherwise.
     * <p>
     * You must write a solution in O(log(m * n)) time complexity.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        var lo = 0;
        var hi = matrix.length;

        var rowLength = matrix[0].length;
        int[] row = null;

        while (lo < hi) {
            var mid = lo + (hi - lo) / 2;

            row = matrix[mid];
            var first = row[0];
            var last = row[rowLength - 1];

            if (first == target || last == target) return true;
            else if (first < target && last > target) break;

            else if (first < target) lo = mid + 1;
            else hi = mid;
        }

        lo = 0;
        hi = rowLength;

        while (lo < hi) {
            var mid = lo + (hi - lo) / 2;
            var current = row[mid];

            if (current == target) return true;
            else if (current < target) lo = mid + 1;
            else hi = mid;
        }

        return false;
    }
}
