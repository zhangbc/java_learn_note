package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 20:57
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                dist = Math.min(dist, i - map.get(nums[i]));
            }

            map.put(nums[i], i);
        }

        return dist <= k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(new Solution219().containsNearbyDuplicate(nums, 2));

        int[] nums2 = {1, 0, 1, 1};
        System.out.println(new Solution219().containsNearbyDuplicate(nums2, 1));
    }
}
