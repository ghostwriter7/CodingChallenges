package com.rozplochowski.coding.linkedlist;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        var curr = head;
        var next = curr == null ? null : curr.next;
        if (head != null) head.next = null;

        while (next != null) {
            var temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }

        return curr;
    }

    public static class ListNode {

        ListNode next;
        int val;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
