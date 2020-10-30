package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/23 14:13
 */
public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idx = map.getOrDefault(nums[i], new ArrayList<>());
            idx.add(i);
            map.put(nums[i], idx);
        }

        // 计算数组的度
        int maxCount = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue().size());
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() == maxCount) {
                ans = Math.min(ans, indexes.get(maxCount - 1) - indexes.get(0));
            }
        }

        return ans + 1;
    }

    public int findShortestSubArray2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>(16);
        // 数组的度
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idx = map.getOrDefault(nums[i], new ArrayList<>());
            idx.add(i);
            map.put(nums[i], idx);
            List<Integer> indexes = map.get(nums[i]);
            maxCount = Math.max(maxCount, indexes.size());
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() == maxCount) {
                ans = Math.min(ans, indexes.get(maxCount - 1) - indexes.get(0));
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(new Solution697().findShortestSubArray2(nums));
    }
}
