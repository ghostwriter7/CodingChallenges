package com.rozplochowski.coding.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * <p>
 * Implement the SmallestInfiniteSet class:
 * <p>
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 1000
 * At most 1000 calls will be made in total to popSmallest and addBack.
 */
public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final Set<Integer> set = new HashSet<>();
    private int next = 1;

    public SmallestInfiniteSet() {}

    public int popSmallest() {
        if (!queue.isEmpty()) {
            var min = queue.poll();
            set.remove(min);
            return min;
        }

        return next++;
    }

    public void addBack(int num) {
        if (num < next && !set.contains(num)) {
            set.add(num);
            queue.offer(num);
        }
    }
}