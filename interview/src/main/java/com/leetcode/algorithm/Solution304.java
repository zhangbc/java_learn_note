package com.leetcode.algorithm;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/3/2 12:35
 */
public class Solution304 {
}


class NumMatrix {

    int[][] numbers;
    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length < 1) {
            return;
        }

        numbers = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, numbers[i], 0, matrix[i].length);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += numbers[i][j];
            }
        }

        return sum;
    }
}


class NumMatrix1 {

    int[][] sum;
    public NumMatrix1(int[][] matrix) {

        if (matrix == null || matrix.length < 1) {
            return;
        }

        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] + sum[row2 + 1][col1] - sum[row1][col1];
    }
}
