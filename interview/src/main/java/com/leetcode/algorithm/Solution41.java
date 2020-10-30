package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/12 21:09
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        Arrays.sort(nums);
        int i = 0, min, j = 1;
        while (i < nums.length) {
            if (nums[i] <= 0) {
                i++;
                continue;
            }

            min = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == min) {
                i++;
            }

            if (min == j) {
                i++;
                j++;
            } else {
                return j;
            }
        }

        return j;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] < length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
