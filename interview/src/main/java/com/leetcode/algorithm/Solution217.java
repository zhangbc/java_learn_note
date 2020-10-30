package com.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 21:08
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>(16);
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}
