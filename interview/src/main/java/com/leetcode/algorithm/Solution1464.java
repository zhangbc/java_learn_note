package com.leetcode.algorithm;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 22:01
 */
public class Solution1464 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxSecond = nums[0], max = nums[1];
        if (nums[0] > nums[1]) {
                maxSecond = nums[1];
                max = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > maxSecond) {
                if (nums[i] >= max) {
                    maxSecond = max;
                    max = nums[i];
                } else {
                    maxSecond = nums[i];
                }
            }
        }

        return (maxSecond - 1) * (max - 1);
    }
}
