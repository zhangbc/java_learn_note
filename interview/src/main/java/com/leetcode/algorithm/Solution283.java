package com.leetcode.algorithm;

/**
 * 283. 移动零
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 09:11
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
