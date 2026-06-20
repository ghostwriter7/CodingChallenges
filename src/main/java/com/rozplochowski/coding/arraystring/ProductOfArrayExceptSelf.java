package com.rozplochowski.coding.arraystring;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {
    public int[] compute(int[] nums) {
        var products = new int[nums.length];
        products[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }

        var suffix = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            products[i] *= suffix;
            suffix *= nums[i];
        }

        return products;
    }
}
