package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1512. 好数对的数目
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 14:56
 */
public class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>(16);
        List<Integer> indexes;
        for (int i = 0; i < nums.length; i++) {
            indexes = new ArrayList<>(16);
            if (map.containsKey(nums[i])) {
                indexes = map.get(nums[i]);
            }

            indexes.add(i);
            map.put(nums[i], indexes);
        }

        int ans = 0;
        for (Integer item: map.keySet()) {
            indexes = map.get(item);
            if (indexes.size() <= 1) {
                continue;
            }

            ans += indexes.size() * (indexes.size() - 1) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int ans = new Solution1512().numIdenticalPairs(nums);
        System.out.println(ans);
    }
}
