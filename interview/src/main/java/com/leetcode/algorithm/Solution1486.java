package com.leetcode.algorithm;

/**
 * 1486. 数组异或操作
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/13 00:30
 */
public class Solution1486 {
    public int xorOperation(int n, int start) {
        if (n < 1) {
            return 0;
        }

        int sum = start;
        while (n > 1) {
            sum ^= (start + 2 * (n - 1));
            n--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1486().xorOperation(4, 3));
    }
}
