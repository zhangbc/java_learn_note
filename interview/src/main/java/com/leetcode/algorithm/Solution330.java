package com.leetcode.algorithm;

/**
 * 330. 按要求补齐数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/29 23:07
 */
public class Solution330 {
    public int minPatches(int[] nums, int n) {
        if (nums == null) {
            return 0;
        }

        int ans = 0, pos = 0;
        long current = 0, i = 1;
        while (i <= n) {
            if (pos >= nums.length || i < nums[pos]) {
                ans++;
                current += i;
            } else {
                current += nums[pos];
                pos++;
            }

            i = current + 1;
        }

        return ans;
    }
}
