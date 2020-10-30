package com.leetcode.algorithm;

/**
 * 905. 按奇偶排序数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 20:38
 */
public class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }

        int low = 0, high = A.length - 1;
        while (low < high) {
            if (A[low] % 2 == 0) {
                low++;
                continue;
            }

            if (A[high] % 2 == 1) {
                high--;
                continue;
            }

            swap(A, low, high);
            low++;
            high--;
        }

        return A;
    }

    private void swap(int[] a, int low, int high) {
        int tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
    }
}
