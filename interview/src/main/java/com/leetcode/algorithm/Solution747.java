package com.leetcode.algorithm;

/**
 * 747. 至少是其他数字两倍的最大数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 23:10
 */
public class Solution747 {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        for (int num: nums) {
            if (num == 0) {
                continue;
            }

            if (num != max && max / num < 2) {
                return -1;
            }
        }

        return index;
    }
}
