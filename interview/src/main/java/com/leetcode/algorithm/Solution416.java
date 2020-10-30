package com.leetcode.algorithm;

/**
 * 416. 分割等和子集
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/11 10:05
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = 0, count = 2;
        for (int item: nums) {
            sum += item;
        }

        if (sum % count != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] array = {14,9,8,4,3,2};
        System.out.println(new Solution416().canPartition(array));
    }
}
