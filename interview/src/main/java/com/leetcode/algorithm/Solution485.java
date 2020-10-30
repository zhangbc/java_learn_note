package com.leetcode.algorithm;

/**
 * 485. 最大连续1的个数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/21 23:43
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int temp = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                temp += num;
                max = Math.max(max, temp);
            } else {
                temp = 0;
            }
        }

        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int start = 0, end = 0;
        int max = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                max = Math.max(max, end - start);
                start = end + 1;
                end = start;
            }
        }

        return Math.max(max, end - start);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new Solution485().findMaxConsecutiveOnes2(nums));
    }
}
