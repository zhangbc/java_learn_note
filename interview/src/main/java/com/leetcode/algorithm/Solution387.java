package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/23 11:26
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
