package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1304. 和为零的N个唯一整数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 20:29
 */
public class Solution1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int half = n >> 1;
        while (half >= 0) {
            if (half != n - half - 1) {
                ans[half] = (half + 1);
                ans[n - half - 1] = -(half + 1);
            }

            half--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] ans = new Solution1304().sumZero(n);
        System.out.println(Arrays.toString(ans));
    }
}
