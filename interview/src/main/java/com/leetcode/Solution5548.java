package com.leetcode;

/**
 * 5548. 最小体力消耗路径
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 11:12
 */
public class Solution5548 {
    public int minimumEffortPath(int[][] heights) {
        if (heights == null || heights.length < 1 || heights[0].length < 1) {
            return 0;
        }

        int rows = heights.length, cols = heights[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = heights[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = Math.abs(dp[i - 1][0] - heights[i][0]);
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = Math.abs(dp[0][j - 1] - heights[0][j]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.abs(Math.min(dp[i - 1][j], dp[i][j - 1]) - heights[i][j]);
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
