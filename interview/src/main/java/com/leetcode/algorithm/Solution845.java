package com.leetcode.algorithm;

/**
 * 845. 数组中的最长山脉
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 09:26
 */
public class Solution845 {
    public int longestMountain(int[] A) {
        int len = 3;
        if (A == null || A.length < len) {
            return 0;
        }

        boolean asc = false, desc = false;
        int temp = 0, maxLength = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                if (desc) {
                    maxLength = Math.max(maxLength, ++temp);
                }

                asc = false;
                desc = false;
                temp = 0;
                continue;
            }

            if (A[i - 1] < A[i]) {
                if (!asc && !desc) {
                    asc = true;
                    temp = 1;
                    continue;
                }

                if (asc) {
                    temp++;
                }

                if (!asc) {
                    asc = true;
                    desc = false;
                    maxLength = Math.max(maxLength, ++temp);
                    temp = 1;
                }
            }

            if (A[i - 1] > A[i]) {
                if (!asc && !desc) {
                    continue;
                }

                temp++;
                desc = true;
                asc = false;
            }
        }

        if (desc) {
            maxLength = Math.max(maxLength, ++temp);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {0,0,0,0,0,1,1,1,1,1};
        System.out.println(new Solution845().longestMountain(array));
    }
}
