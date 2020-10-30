package com.leetcode.algorithm;

/**
 * 766. 托普利茨矩阵
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/23 15:22
 */
public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (i + 1 < matrix.length && matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
