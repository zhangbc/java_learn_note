package com.leetcode.algorithm;

/**
 * 29. 两数相除
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 16:41
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);

        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (dd >> i >= dr) {
                count += 1 << i;
                dd -= dr << i;
            }
        }

        return flag ? count : -count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(-2147483648, -2));
        System.out.println(new Solution29().divide(10, 3));
    }
}
