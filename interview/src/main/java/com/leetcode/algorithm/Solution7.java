package com.leetcode.algorithm;

/**
 * 7. 整数反转
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/5/3 16:59
 */
public class Solution7 {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return (int) ans == ans ? (int)ans : 0;
    }
}
