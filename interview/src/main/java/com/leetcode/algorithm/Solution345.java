package com.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/25 13:56
 */
public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Set<Character> set = new HashSet<>(16);
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] chars = s.toCharArray();
        int high = s.length() - 1, low = 0;
        while (low < high) {
            if (!set.contains(chars[low])) {
                low++;
                continue;
            }

            if (!set.contains(chars[high])) {
                high--;
                continue;
            }

            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }

        return String.valueOf(chars);
    }
}
