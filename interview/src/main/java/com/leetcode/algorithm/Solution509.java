package com.leetcode.algorithm;

/**
 * 509. 斐波那契数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/21 17:03
 */
public class Solution509 {
    public int fib(int N) {
        if (N < 1) {
            return 0;
        }

        int pre = 0, cur = 1, next = 1;
        for (int i = 1; i < N; i++) {
            next = cur + pre;
            pre = cur;
            cur = next;
        }

        return next;
    }

    public int fib2(int N) {
        if (N < 1) {
            return 0;
        }

        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }

    public static void main(String[] args) {
        System.out.println(new Solution509().fib(4));
    }
}
