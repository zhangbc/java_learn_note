package com.leetcode.algorithm;

/**
 * 421. 数组中两个数的最大异或值（暴力解法超时）
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/27 15:41
 */
public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }

        return ans;
    }
}
