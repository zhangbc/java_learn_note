package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/2 11:19
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>(16);
        for (Integer item: nums2) {
            set.add(item);
        }

        Set<Integer> res = new HashSet<>(16);
        for (Integer item: nums1) {
            if (set.contains(item)) {
                res.add(item);
            }
        }

        int[] array = new int[res.size()];
        int index = 0;
        for (Integer s: res) {
            array[index++] = s;
        }

        return array;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution349().intersection(nums1, nums2)));
    }
}
