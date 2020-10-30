package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 12:04
 */
public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        if ((R <=0 && C <= 0) || R < 0 || C < 0 || r0 < 0 || c0 < 0) {
            return new int[0][0];
        }

        int[][] ans = new int[R * C][2];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[idx][0] = i;
                ans[idx++][1] = j;
            }
        }

        Arrays.sort(ans, (o1, o2) -> {
            int d1 = dist(o1, r0, c0);
            int d2 = dist(o2, r0, c0);
            return d1 - d2;
        });

        return ans;
    }

    private int dist(int[] o, int r, int c) {
        return Math.abs(o[0] - r) + Math.abs(o[1] - c);
    }

    public static void main(String[] args) {
        int[][] ans = new Solution1030().allCellsDistOrder(3, 4, 1, 1);
        for (int[] a: ans) {
            System.out.printf("%s", Arrays.toString(a));
        }
    }
}
