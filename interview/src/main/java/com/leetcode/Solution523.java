package com.leetcode;

/**
 * 523. 连续的子数组和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/20 00:10
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);

        int count = 2;
        while (count <= nums.length) {
            for (int i = 0; i + count - 1 < dp.length; i++) {
                dp[i] += nums[i + count - 1];
                if (k == 0 && dp[i] == 0) {
                    return true;
                }

                if (k != 0 && dp[i] % k == 0) {
                    return true;
                }
            }
            count++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {23,2,6,4,7};
        System.out.println(new Solution523().checkSubarraySum(array, 6));
    }
}
