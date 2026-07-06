package com.rozplochowski.coding.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    ListNode next;
    int val;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        var curr = this;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
 }