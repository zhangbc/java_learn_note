package com.leetcode.algorithm;

/**
 * 5640. 与数组中元素的最大异或值
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/27 14:53
 */
public class Solution5640 {
    /**
     * 暴力解法解法超时
     */
    public int[] maximizeXor(int[] nums, int[][] queries) {
        if (nums == null || nums.length < 1 || queries == null || queries.length < 1) {
            return new int[0];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], m = queries[i][1], res = -1;
            for (int num: nums) {
                if (num <= m) {
                    res = Math.max(res, num ^ x);
                }
            }

            answer[i] = res;
        }

        return answer;
    }

    public int[] maximizeXor2(int[] nums, int[][] queries) {
        if (nums == null || nums.length < 1 || queries == null || queries.length < 1) {
            return new int[0];
        }

        return nums;
    }
}
