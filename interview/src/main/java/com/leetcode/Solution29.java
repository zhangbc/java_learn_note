package com.leetcode;

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
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int count = 0;
        while (dividend - divisor <= 0) {
            int temp = divisor;
            int ctemp = 1;
            while (dividend - temp <= temp) {
                temp <<= 1;
                ctemp <<= 1;
            }

            dividend -= temp;
            count += ctemp;
        }

        return flag ? count : -count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(-2147483648, -2));
    }
}
