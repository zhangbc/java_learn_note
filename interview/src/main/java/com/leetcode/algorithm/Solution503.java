package com.leetcode.algorithm;

/**
 * 503. 下一个更大元素 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/6 11:23
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = getNextMax(i, nums);
        }

        return result;
    }

    private int getNextMax(int i, int[] nums) {
        int start = nums[i], j = (i + 1) % nums.length;
        while (true) {
            if (start < nums[j]) {
                return nums[j];
            }

            j = (j + 1) % nums.length;
            if (j == i) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution503 cls = new Solution503();
        cls.nextGreaterElements(nums);
    }
}
