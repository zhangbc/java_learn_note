package com.leetcode.algorithm;

/**
 * 1550. 存在连续三个奇数的数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 23:55
 */
public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }

        return false;
    }
}
