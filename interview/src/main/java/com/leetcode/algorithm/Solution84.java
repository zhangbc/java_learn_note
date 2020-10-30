package com.leetcode.algorithm;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/26 19:30
 */
public class Solution84 {
    /**
     * 方法一：暴力解法
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        int ans = 0, length = heights.length;
        for (int i = 0; i < length; i++) {
            int height = heights[i], left = i, right = i;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }

            while (right < length && heights[right] >= height) {
                right++;
            }

            ans = Math.max(ans, height * (right - left - 1));
        }

        return ans;
    }

    /**
     * 方法二：
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution84 cls = new Solution84();
        System.out.println(cls.largestRectangleArea(heights));
    }
}
