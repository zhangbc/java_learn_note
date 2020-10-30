package com.leetcode.algorithm;

/**
 * 201. 数字范围按位与
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/31 00:18
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }

        return n;
    }

    public static void main(String[] args) {
        Solution201 cls = new Solution201();
        System.out.println(cls.rangeBitwiseAnd(5,7));
    }
}
