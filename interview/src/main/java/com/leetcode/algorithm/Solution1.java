package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/3 15:28
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int pos = map.getOrDefault(target - nums[i], -1);
            if (pos >= 0) {
                return new int[]{pos, i};
            } else {
                map.put(nums[i], i);
            }
        }

        return array;
    }
}
