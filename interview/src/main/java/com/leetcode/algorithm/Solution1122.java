package com.leetcode.algorithm;

/**
 * 1122. 数组的相对排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/14 16:16
 */
public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length <= 1 || arr2 == null || arr2.length < 1) {
            return arr1;
        }

        int max = arr1[0];
        for (int i: arr1) {
            max = Math.max(max, i);
        }

        int[] bucket = new int[max + 1];
        for (int i: arr1) {
            bucket[i]++;
        }

        int j = 0;
        for (int i: arr2) {
            while (bucket[i] > 0) {
                arr1[j++] = i;
                bucket[i]--;
            }
        }

        for (int i = 0; i < max + 1; i++) {
            while (bucket[i] > 0) {
                arr1[j++] = i;
                bucket[i]--;
            }
        }

        return arr1;
    }
}
