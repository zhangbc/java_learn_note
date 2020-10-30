package com.leetcode.algorithm;

/**
 * 867. 转置矩阵
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/5 23:30
 */
public class Solution867 {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length < 1) {
            return A;
        }

        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
}
