package com.leetcode.algorithm;

/**
 * 62. 不同路径
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/9 11:00
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (n < 1 || m < 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (n < 1 || m < 1) {
            return 0;
        }

        long ans = 1;
        for (int i = 1, j = n; i < m; i++, j++) {
            ans = ans * j / i;
        }

        return (int)ans;
    }

    public int uniquePaths3(int m, int n) {
        if (n < 1 || m < 1) {
            return 0;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution62 cls = new Solution62();
        int m = 1, n = 2;
        System.out.println(cls.uniquePaths(m, n));
    }
}
