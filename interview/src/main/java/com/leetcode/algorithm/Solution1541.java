package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 1541. 平衡括号字符串的最少插入次数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/8 17:43
 */
public class Solution1541 {
    public int minInsertions(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            // '('入栈
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                i++;
            } else {

                if (stack.isEmpty()) {
                    // 栈空，需要补左括号
                    res++;
                } else {
                    // 出栈
                    stack.pop();
                }

                // 找第二个右括号
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i += 2;
                } else {
                    res++;
                    i++;
                }
            }
        }

        while (!stack.isEmpty()) {
            res += 2;
            stack.pop();
        }

        return res;
    }
}
