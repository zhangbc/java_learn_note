package com.leetcode.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 22:52
 */
public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
