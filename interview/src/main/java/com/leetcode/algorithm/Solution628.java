package com.leetcode.algorithm;

/**
 * 628. 三个数的最大乘积
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/16 22:09
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // 最小数
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大数
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x: nums) {
            // 最小两个数
            if (x < min2) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else {
                    min2 = x;
                }
            }

            // 最大三个数
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        int ans0 = Math.max(min1 * min2 * max1, max1 * max2 * max3);
        return Math.max(min1 * min2 * max3, ans0);
    }
}
