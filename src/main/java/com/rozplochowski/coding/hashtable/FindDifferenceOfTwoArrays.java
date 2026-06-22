package com.rozplochowski.coding.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
public class FindDifferenceOfTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (var num : nums1) {
            set1.add(num);
        }

        var set2 = new HashSet<Integer>();
        for (var num : nums2) {
            set2.add(num);
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (var num : set1) {
            if (!set2.contains(num)) {
                first.add(num);
            }
        }

        for (var num : set2) {
            if (!set1.contains(num)) {
                second.add(num);
            }
        }

        return List.of(first, second);
    }
}
