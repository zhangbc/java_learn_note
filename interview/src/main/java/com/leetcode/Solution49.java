package com.leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 16:09
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length < 1) {
            return new ArrayList<>(16);
        }

        Map<String, List<String>> map = new HashMap<>(16);
        for (String str: strs) {
            String temp = getHashCode(str);
            List<String> s;
            if (map.containsKey(temp)) {
                s = map.get(temp);
            } else {
                s = new ArrayList<>(16);
            }
            s.add(str);
            map.put(temp, s);
        }

        return new ArrayList<>(map.values());
    }

    private String getHashCode(String str) {
        if (str == null || str.length() < 1) {
            return " ";
        }

        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return String.valueOf(chs);
    }
}
