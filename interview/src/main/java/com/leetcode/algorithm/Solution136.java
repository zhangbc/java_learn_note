package com.leetcode.algorithm;

/**
 * 136. 只出现一次的数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/31 12:54
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
}
