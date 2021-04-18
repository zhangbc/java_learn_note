package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 71. 简化路径
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/10 16:16
 */
public class Solution71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return path;
        }

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str: paths) {
            if (str.length() < 1 || ".".equals(str)) {
                continue;
            }

            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.length() > 1 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        Solution71 cls = new Solution71();
        String path = "/../";
        System.out.println(cls.simplifyPath(path));
    }
}
