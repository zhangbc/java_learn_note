package com.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.10. 主要元素
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/12 12:38
 */
public class Solution1710 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int half = nums.length >> 1;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.getOrDefault(num, 0) > half) {
                return num;
            }
        }

        return -1;
    }

    /**
     * 摩尔投票算法：
     *    每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，
     *    就是出现次数大于总数一半的那个。
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int mid = nums[0];
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                mid = num;
                count++;
            } else if (mid == num) {
                count++;
            } else {
                count--;
            }
        }

        int ans = count > 0 ? mid : -1;
        int half = nums.length >> 1;
        if (ans != -1) {
            count = 0;
            for (int num: nums) {
                if (ans == num) {
                    count++;
                }

                if (count > half) {
                    return ans;
                }
            }
        }

        return -1;
    }
}
