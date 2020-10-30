package com.leetcode.algorithm;

/**
 * 38. 外观数列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 17:35
 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        String pre = "1";
        String next = pre;
        for (int i = 2; i <= n; i++) {
            next = getNext(pre);
            pre = next;
        }

        return next;
    }

    private String getNext(String s) {
        int count = 1;
        char p = s.charAt(0);
        int index = 1;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == p) {
                count++;
            } else {
                sb.append(count);
                sb.append(p);

                count = 1;
                p = s.charAt(index);
            }
            index++;
        }

        sb.append(count);
        sb.append(p);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(4));
    }
}
