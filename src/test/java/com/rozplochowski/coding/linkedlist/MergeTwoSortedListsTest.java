package com.rozplochowski.coding.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldMergeTwoSortedLists(int[] list1, int[] list2, int[] expected) {
        assertArrayEquals(expected, MergeTwoSortedLists.mergeTwoLists(create(list1), create(list2)).toArray());
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[] {1,2,4}, new int[] {1,3,4}, new int[] {1,1,2,3,4,4})
        );
    }

    private static ListNode create(int[] values) {
        var head = new ListNode(values[0]);
        var current = head;
        for (var i = 1; i < values.length; i++) {
            var node = new ListNode(values[i]);
            current.next = node;
            current = node;
        }

        return head;
    }

}