package com.leetcode.algorithm;

/**
 * 12. 整数转罗马数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 23:45
 */
public class Solution12 {
    public String intToRoman(int num) {
        if (num < 0) {
            return null;
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keys = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < values.length) {
            if (num - values[i] >= 0) {
                sb.append(keys[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
