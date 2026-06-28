package com.rozplochowski.coding.heap;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (k == 1 && nums.length == 1) return nums[0];

        var heap = new MaxHeap(nums.length);
        for (var num : nums) heap.add(num);
        for (var i = 0; i < k - 1; i++) heap.remove();

        return heap.remove();
    }

    private static class MaxHeap {

        private final int[] heap;
        private int size = 0;

        private MaxHeap(int size) {
            heap = new int[size];
        }

        private void add(int value) {
            if (size == 0) {
                heap[0] = value;
                size++;
                return;
            }

            heap[size++] = value;
            heapifyUp(size - 1);
        }

        private void heapifyUp(int index) {
            if (index == 0) return;

            var value = heap[index];
            var parent = (index - 1) / 2;
            var pValue = heap[parent];

            if (pValue < value) {
                heap[index] = pValue;
                heap[parent] = value;
                heapifyUp(parent);
            }
        }

        private int remove() {
            var value = heap[0];
            heap[0] = heap[--size];

            heapifyDown(0);

            return value;
        }

        private void heapifyDown(int index) {
            var value = heap[index];
            var lChild = 2 * index + 1;

            if (lChild >= size) return;
            var rChild = 2 * index + 2;

            var lValue = heap[lChild];

            var target = rChild >= size ? lValue : (Math.max(lValue, heap[rChild]));

            if (target > value) {
                var childIdx = target == lValue ? lChild : rChild;
                heap[index] = target;
                heap[childIdx] = value;
                heapifyDown(childIdx);
            }
        }

    }
}
