package com.leetcode.algorithm;

/**
 * 59. 螺旋矩阵 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/17 19:04
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }

        int[][] ans = new int[n][n];
        int i = 0, j = 0, s = n * n;
        for (int k = 1; k <= s; k++) {
            ans[i][j] = k;
            if (j < n) {
                if (j + 1 <= n && ans[i][j + 1] == 0) {
                    j++;
                }
            } else if (j == n) {

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution59 cls = new Solution59();
        cls.generateMatrix(5);
    }
}
