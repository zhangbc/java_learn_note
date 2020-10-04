package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 20:09
 */
public class Solution10272 {
    public int bitModulus (int a, int b) {
        // write code here
        return a & (b - 1);
    }
}
