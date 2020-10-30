package com.leetcode.algorithm;

/**
 * 852. 山脉数组的峰顶索引
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/3 10:36
 */
public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }

        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (arr[low] < arr[mid]) {
                low++;
            } else {
                high--;
            }
        }

        return low;
    }
}
