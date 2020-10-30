package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 10:29
 */
public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length < 1 || chars == null || chars.length() < 1) {
            return 0;
        }

        Map<Character, Integer> mapChars = GenerateMap(chars);

        int ans = 0;
        for (String word: words) {
            Map<Character, Integer> map = new HashMap<>(16);
            map.putAll(mapChars);
            int i = 0;
            while (i < word.length()) {
                char ch = word.charAt(i);
                if (map.getOrDefault(ch, 0) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    i++;
                } else {
                    i = word.length() + 1;
                }
            }

            ans += (i == word.length() ? word.length() : 0);
        }

        return ans;
    }

    private Map<Character, Integer> GenerateMap(String chars) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        // String[] words = {"cat", "bt", "hat", "tree"};
        // String chars = "atach";
        // int ans = new Solution1160().countCharacters(words, chars);
        // System.out.println(ans);

        String[] words2 = {"hello","world","leetcode"};
        String chars2 = "welldonehoneyr";
        int ans2 = new Solution1160().countCharacters(words2, chars2);
        System.out.println(ans2);
    }
}
