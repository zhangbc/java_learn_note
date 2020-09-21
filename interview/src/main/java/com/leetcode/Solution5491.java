package com.leetcode;

/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 23:42
 */
public class Solution5491 {
    public int diagonalSum(int[][] mat) {
        int dig = 0;
        int antDig = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            dig += mat[i][i];
            if (i != n - 1 - i) {
                antDig += mat[i][n - i - 1];
            }
        }

        return dig + antDig;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution5491().diagonalSum(mat));
    }
}
