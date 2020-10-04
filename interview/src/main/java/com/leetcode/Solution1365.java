package com.leetcode;

/**
 * 1365. 有多少小于当前数字的数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 00:11
 */
public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        int length = nums.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    temp++;
                }
            }

            array[i] = temp;
        }

        return array;
    }
}
