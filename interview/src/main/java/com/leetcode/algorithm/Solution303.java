package com.leetcode.algorithm;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/1 20:42
 */
public class Solution303 {
}


class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
