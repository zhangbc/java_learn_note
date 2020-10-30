package com.leetcode.offer;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 13:27
 */
public class Solution05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        StringBuilder chs = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                chs.insert(0, '0');
                chs.insert(0, '2');
                chs.insert(0, '%');
            } else {
                chs.insert(0, s.charAt(i));
            }
        }

        return chs.toString();
    }
}
