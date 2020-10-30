package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/29 15:00
 */
public class Solution976 {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }

        Arrays.sort(A);

        int maxPerimeter = 0;
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] + A[i - 1] > A[i - 2] && A[i] + A[i - 2] > A[i - 1] && A[i - 1] + A[i - 2] > A[i]) {
                maxPerimeter = Math.max(maxPerimeter, A[i] + A[i - 1] + A[i - 2]);
            }
        }

        return maxPerimeter;
    }
}
