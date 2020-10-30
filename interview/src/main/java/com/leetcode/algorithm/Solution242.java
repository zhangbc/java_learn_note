package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 11:22
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, long[]> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new long[]{map.get(s.charAt(i))[0] + 1, map.get(s.charAt(i))[1]});
            } else {
                map.put(s.charAt(i), new long[]{1, 0});
            }

            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new long[]{map.get(t.charAt(i))[0], map.get(t.charAt(i))[1] + 1});
            } else {
                map.put(t.charAt(i), new long[]{0, 1});
            }
        }

        for (long[] value: map.values()) {
            if (value[0] != value[1]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss, tt);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution242().isAnagram2(s, t));
    }
}
