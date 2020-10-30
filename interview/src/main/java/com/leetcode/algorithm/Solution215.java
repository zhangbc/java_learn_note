package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/23 15:18
 */
public class Solution215 {
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1 || k > nums.length) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1 || k > nums.length) {
            return -1;
        }

        int length = nums.length, low = 0, high = length - 1;
        int target = length - k;
        while (true) {
            int pos = partition(nums, low, high);
            if (pos == target) {
                return nums[pos];
            } else if (pos < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        int key = nums[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < key) {
                j++;
                swap(nums, i, j);
            }
        }

        swap(nums, j, low);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
        for (int n: nums) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}
