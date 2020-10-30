package com.leetcode.algorithm;

/**
 * 169. 多数元素
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 23:45
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
            }

            count += (num == nums[i] ? 1 : -1);
        }

        return num;
    }
}
