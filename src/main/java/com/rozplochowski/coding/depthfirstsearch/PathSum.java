package com.rozplochowski.coding.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.rozplochowski.coding.TreeNode;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */
public class PathSum {
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return pathSum(root, targetSum, prefix, 0);
    }

    private static int pathSum(TreeNode node, int targetSum, Map<Long, Integer> prefix, long currentSum) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefix.getOrDefault(currentSum - targetSum, 0);
        prefix.merge(currentSum, 1, Integer::sum);

        count += pathSum(node.left, targetSum, prefix, currentSum);
        count += pathSum(node.right, targetSum, prefix, currentSum);
        prefix.merge(currentSum, -1, Integer::sum);

        return count;
    }


    public static int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return countMatches(root, new ArrayList<>(), targetSum);
    }

    private static int countMatches(TreeNode node, List<Long> sums, int target) {
        if (node == null) return 0;

        var value = node.val;
        var count = 0;
        for (var i = 0; i < sums.size(); i++) {
            var updated = sums.get(i) + value;
            sums.set(i, updated);
            if (updated == target) count++;
        }

        sums.add((long) value);

        if (value == target) {
            count++;
        }

        count += countMatches(node.left, sums, target);
        count += countMatches(node.right, sums, target);

        sums.removeLast();
        sums.replaceAll(s -> s - value);

        return count;
    }


}
