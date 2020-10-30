package com.leetcode.algorithm;

/**
 * 1370. 上升下降字符串
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/25 12:17
 */
public class Solution1370 {
    public String sortString(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] > 0) {
                    sb.append((char) (i + 'a'));
                    bucket[i]--;
                }
            }

            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] > 0) {
                    sb.append((char) (i + 'a'));
                    bucket[i]--;
                }
            }
        }

        return sb.toString();
    }
}
