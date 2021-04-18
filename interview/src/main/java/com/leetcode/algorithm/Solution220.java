package com.leetcode.algorithm;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 21:45
 */
public class Solution220 {
    /**
     * 超时算法
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long)nums[j] - (long)nums[i]) <= t && j - i <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long) nums[i] - (long) t);
            if (ceil != null && ceil <= (long) nums[i] + (long) t) {
                return true;
            }

            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, 2147483647};
        System.out.println(new Solution220().containsNearbyAlmostDuplicate(nums, 3, 3));

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(new Solution220().containsNearbyAlmostDuplicate2(nums1, 3, 0));

    }
}
