package com.leetcode.algorithm;

/**
 * 463. 岛屿的周长
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/30 00:02
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int circle = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                // 上下边
                if (i == 0 || grid[i - 1][j] == 0) {
                    circle += 2;
                }

                // 左右边
                if (j == 0 || grid[i][j - 1] == 0) {
                    circle += 2;
                }
            }
        }

        return circle;
    }
}
