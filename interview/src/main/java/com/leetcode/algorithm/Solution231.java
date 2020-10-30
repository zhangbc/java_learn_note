package com.leetcode.algorithm;

/**
 * 231. 2的幂
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 16:30
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        int m = 0;
        while (true) {
            if (Math.pow(2, m) == n) {
                return true;
            }

            if (Math.pow(2, m) > n) {
                return false;
            }

            m++;
        }
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
