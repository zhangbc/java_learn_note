package com.leetcode.algorithm;

/**
 * 11. 盛最多水的容器
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/25 16:41
 */
public class Solution11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }

        int ans = 0, low = 0, high = height.length - 1;
        while (low < high) {
            ans = Math.max(ans, Math.min(height[low], height[high]) * (high - low));
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return ans;
    }
}
