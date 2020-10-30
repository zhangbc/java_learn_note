package com.leetcode.algorithm;

/**
 * 268. 丢失的数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 22:01
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res  = res ^ i ^ nums[i];
        }

        return res;
    }
}
