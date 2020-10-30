package com.leetcode.algorithm;

/**
 * 137. 只出现一次的数字 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/31 12:57
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int one = 0, two = 0;
        for (int num: nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }

        return one;
    }

    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int bit = 32;
        int[] counts = new int[bit];
        for (int num: nums) {
            for (int i = 0; i < bit; i++) {
                counts[i] += num & 1;
                num >>>= 1;
            }
        }

        int ans = 0, m = 3;
        for (int i = 0; i < bit; i++) {
            ans <<= 1;
            ans |= counts[bit - 1 - i] % m;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        Solution137 cls = new Solution137();
        System.out.println(cls.singleNumber(nums));
    }
}
