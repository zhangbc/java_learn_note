package com.leetcode.interview;

/**
 * 面试题 17.04. 消失的数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 23:58
 */
public class Solution1704 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        long sum = nums.length * (nums.length + 1) / 2;
        for (int num: nums) {
            sum -= num;
        }

        return (int) sum;
    }

    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i;
            ans ^= nums[i];
        }

        ans ^= nums.length;

        return ans;
    }
}
