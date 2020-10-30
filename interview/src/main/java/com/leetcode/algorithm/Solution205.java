package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/27 00:04
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() < 1 || t == null || t.length() < 1) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> maps = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (maps.containsKey(cs)) {
                if (maps.get(cs) != ct) {
                    return false;
                }
            } else {
                maps.put(cs, ct);
            }

            if (maps.values().size() != new HashSet<>(maps.values()).size()) {
                return false;
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s == null || s.length() < 1 || t == null || t.length() < 1) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> maps = new HashMap<>(16);
        Map<Character, Character> mapt = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            boolean flag = (maps.containsKey(cs) && maps.get(cs) != ct) || (mapt.containsKey(ct) && mapt.get(ct) != cs);
            if (flag) {
                return false;
            }

            maps.put(cs, ct);
            mapt.put(ct, cs);
        }

        return true;
    }

    public boolean isIsomorphic3(String s, String t) {

        return isomorphic(s, t) && isomorphic(t, s);
    }

    public boolean isomorphic(String s, String t) {
        if (s == null || s.length() < 1 || t == null || t.length() < 1) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (map.containsKey(cs) && map.get(cs) != ct) {
                return false;
            }

            map.put(cs, ct);
        }

        return true;
    }

    /**
     * 转为字符数组是最优化解法
     */
    public boolean isomorphic2(String s, String t) {
        if (s == null || s.length() < 1 || t == null || t.length() < 1) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[128];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (chars[cs[i]] == 0) {
                chars[cs[i]] = ct[i];
            } else if (chars[cs[i]] != ct[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution205 cls = new Solution205();
        System.out.println(cls.isIsomorphic2("aba", "baa"));
    }
}
