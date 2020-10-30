package com.leetcode.algorithm;

import java.util.*;

/**
 * 442. 数组中重复的数据
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 18:45
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length <= 1) {
            return ans;
        }

        Set<Integer> set = new HashSet<>(16);
        for (int num: nums) {
            if (set.contains(num)) {
                ans.add(num);
            } else {
                set.add(num);
            }
        }

        return ans;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length <= 1) {
            return ans;
        }

        for (int num: nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(index + 1));
            }

            nums[index] = - nums[index];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = new Solution442().findDuplicates2(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
