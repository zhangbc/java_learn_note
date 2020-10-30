package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 665. 非递减数列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/5 23:40
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        boolean change = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (change) {
                    if (i >= 2 && nums[i - 2] > nums[i]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = nums[i];
                    }

                    change = false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        new Solution665().checkPossibility(nums);
        System.out.println(Arrays.toString(nums));
    }
}
