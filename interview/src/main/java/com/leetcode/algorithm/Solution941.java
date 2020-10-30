package com.leetcode.algorithm;

/**
 * 941. 有效的山脉数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/3 09:18
 */
public class Solution941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length <= 1) {
            return false;
        }

        int i = 0;
        while (i + 1 < A.length && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == A.length - 1) {
            return false;
        }

        while (i + 1 < A.length && A[i] > A[i + 1]) {
            i++;
        }

        return i == A.length - 1;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 2, 2, 1};
        System.out.println(new Solution941().validMountainArray(array));
    }
}
