package com.leetcode.algorithm;

/**
 * 414. 第三大的数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 11:49
 */
public class Solution414 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Integer.MIN_VALUE;
        }

        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num: nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num != max2 && num != max1) {
                max3 = num;
            }
        }

        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -2147483648};
        System.out.println(new Solution414().thirdMax(nums));
    }
}
