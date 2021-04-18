package com.leetcode.algorithm;

/**
 * 263. 丑数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/10 14:10
 */
public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 1) {
            return n == 1;
        }

        int two = 2, three = 3, five = 5;
        while (n % two == 0 || n % three == 0 || n % five == 0) {
            if (n % 2 == 0) {
                n /= 2;
            }

            if (n % 3 == 0) {
                n /= 3;
            }

            if (n % 5 == 0) {
                n /= 5;
            }
        }

        return n == 1;
    }
}
