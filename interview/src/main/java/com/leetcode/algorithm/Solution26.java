package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 20:39
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            int dp = nums[i];
            if (dp != nums[j]) {
                nums[++i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int n = new Solution26().removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }
}
