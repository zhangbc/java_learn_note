package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 31. 下一个排列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 15:36
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 6, 3, 1};
        new Solution31().nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
}
