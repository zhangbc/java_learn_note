package com.leetcode.algorithm;

/**
 * 896. 单调数列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 16:41
 */
public class Solution896 {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 2) {
            return true;
        }

        // flag: 0，相等；1，升序；-1，降序
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (flag == 0) {
                    flag = 1;
                }
                if (flag == -1) {
                    return false;
                }
            }

            if (A[i - 1] > A[i]) {
                if (flag == 0) {
                    flag = -1;
                }
                if (flag == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isMonotonic2(int[] A) {
        if (A == null || A.length <= 2) {
            return true;
        }

        // flag: 0，相等；1，升序；-1，降序
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            int compare = Integer.compare(A[i - 1], A[i]);
            if (compare != 0) {
                if (flag != 0 && flag != compare) {
                    return false;
                }

                if (flag == 0) {
                    flag = compare;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 4};
        System.out.println(new Solution896().isMonotonic(array));
    }
}
