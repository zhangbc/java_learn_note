package com.leetcode.algorithm;

/**
 * 922. 按奇偶排序数组 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/12 10:26
 */
public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length < 1 || A.length % 2 == 1) {
            return A;
        }

        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }
}
