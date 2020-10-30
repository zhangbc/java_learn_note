package com.leetcode.algorithm;

/**
 * 1232. 缀点成线
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 22:20
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 1) {
            return true;
        }

        for (int i = 1; i < coordinates.length - 1; i++) {
            long d1 = (coordinates[i][1] - coordinates[0][1]) * (coordinates[i + 1][0] - coordinates[0][0]);
            long d2 = (coordinates[i + 1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]);
            if (d1 != d2) {
                return false;
            }
        }

        return true;
    }
}
