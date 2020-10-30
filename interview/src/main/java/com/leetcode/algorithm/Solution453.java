package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 453. 最小移动次数使数组元素相等
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/4 09:59
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        int moves = 0, diff;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            diff = moves + nums[i] - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2147483647};
        System.out.println(new Solution453().minMoves(array));
    }
}
