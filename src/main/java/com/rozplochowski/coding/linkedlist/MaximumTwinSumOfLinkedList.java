package com.rozplochowski.coding.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list
 * is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
 * These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * <p>
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 */
public class MaximumTwinSumOfLinkedList {

    public int pairSum(ListNode head) {

        var max = Integer.MIN_VALUE;
        List<ListNode> nodes = new ArrayList<>();
        var curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        var l = 0;
        var r = nodes.size() - 1;

        while (l < r) {
            var left = nodes.get(l++);
            var right = nodes.get(r--);

            var sum = left.val + right.val;
            max = Math.max(max, sum);
        }

        return max;
    }

    public int pairSum2(ListNode head) {
        if (head == null || head.next == null) return 0;

        var size = 0;
        var curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int[] sums = new int[size / 2];

        curr = head;
        var i = 0;
        var m = size / 2;
        while (i < m) {
            sums[i++] = curr.val;
            curr = curr.next;
        }

        i = sums.length - 1;
        var max = Integer.MIN_VALUE;
        while (curr != null) {
            sums[--i] += curr.val;
            max = Math.max(max, sums[i]);
            curr = curr.next;
        }

        return max;
    }
}
