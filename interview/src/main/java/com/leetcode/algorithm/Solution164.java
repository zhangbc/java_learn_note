package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 164. 最大间距
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/26 10:33
 */
public class Solution164 {
    public int maximumGap(int[] nums) {
        int length = 2;
        if (nums == null || nums.length < length) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }

        return ans;
    }

    public int maximumGap2(int[] nums) {
        int length = 2;
        if (nums == null || nums.length < length) {
            return 0;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }



        return 0;
    }
}
