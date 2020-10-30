package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/23 12:32
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1 || points[0].length <= 1) {
            return 0;
        }

        Arrays.sort(points, (Comparator.comparingInt(o -> o[0])));
        int ans = 1;
        int min = points[0][0], max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > max || points[i][1] < min) {
                min = points[i][0];
                max = points[i][1];
                ans++;
            } else {
                max = Math.min(max, points[i][1]);
                min = Math.max(min, points[i][0]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int ans = new Solution452().findMinArrowShots(points);
        System.out.println(ans);
        System.out.println((char)50);
    }
}
