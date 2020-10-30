package com.leetcode.algorithm;

/**
 * 220. 存在重复元素 III
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 21:45
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) <= t && j - i <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, 2147483647};
        System.out.println(new Solution220().containsNearbyAlmostDuplicate(nums, 3, 3));
    }
}
