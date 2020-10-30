package com.leetcode.algorithm;

/**
 * 541. 反转字符串 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 23:29
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 1 || k <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, i + k - 1);
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        end = Math.min(end, chars.length - 1);
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(new Solution541().reverseStr(s, k));
    }
}
