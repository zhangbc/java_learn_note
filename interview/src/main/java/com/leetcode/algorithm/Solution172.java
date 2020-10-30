package com.leetcode.algorithm;

/**
 *
 * 172. 阶乘后的零
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 23:45
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        return 0;
    }

    public static void main(String[] args) {
        long sum = 1;
        int n = 15;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }

        System.out.println(sum);
    }
}
