package com.leetcode.algorithm;

/**
 * 209. 长度最小的子数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/26 00:36
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s < 1 || nums == null || nums.length < 1) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int begin = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            while (temp >= s) {
                ans = Math.min(ans, i - begin + 1);
                temp -= nums[begin++];
            }
        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
