package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/4 09:11
 */
public class Solution354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 1) {
            return 0;
        }

        Arrays.sort(envelopes, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));

        // 对高度数组寻找 LIS (最长递增子序列（Longes Increasing Subsequence，简写为 LIS）)
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int p : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= p) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left == piles) {
                piles++;
            }

            top[left] = p;
        }

        return piles;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Solution354 cls = new Solution354();
        cls.maxEnvelopes(envelopes);
    }
}
