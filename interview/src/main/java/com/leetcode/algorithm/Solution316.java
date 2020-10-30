package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 316. 去除重复字母
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/20 17:52
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();
        int[] lastIndexes = new int[26];
        for (int i = 0; i < length; i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && lastIndexes[stack.peek() - 'a'] > i) {
                Character top = stack.pop();
                visited[top - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
