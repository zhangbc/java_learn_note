package com.leetcode.algorithm;

/**
 * 300. 最长递增子序列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/4 10:55
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int poker : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left == piles) {
                piles++;
            }

            top[left] = poker;
        }

        return piles;
    }
}
