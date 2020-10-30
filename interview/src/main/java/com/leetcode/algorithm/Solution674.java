package com.leetcode.algorithm;

/**
 * 674. 最长连续递增序列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/27 12:41
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int max = 1, i = 0, j;
        while (i < nums.length) {
            j = i;
            while (j < nums.length - 1 && nums[j] < nums[j + 1]) {
                j++;
            }

            max = Math.max(max, j - i + 1);
            i = i < j ? j : i + 1;
        }

        return max;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int max = 1, j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                j = i;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}
