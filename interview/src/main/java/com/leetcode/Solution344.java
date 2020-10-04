package com.leetcode;

/**
 * 344. 反转字符串
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/3 00:08
 */
public class Solution344 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int high = s.length - 1, low = 0;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
