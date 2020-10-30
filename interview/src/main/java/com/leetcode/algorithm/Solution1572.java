package com.leetcode.algorithm;

/**
 * 1572. 矩阵对角线元素的和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 23:42
 */
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int diag = 0;
        int antDiag = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            diag += mat[i][i];
            if (i != n - 1 - i) {
                antDiag += mat[i][n - i - 1];
            }
        }

        return diag + antDiag;
    }
}
