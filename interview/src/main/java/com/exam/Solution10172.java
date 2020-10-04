package com.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 16:28
 */
public class Solution10172 {
    public String removeDup (String str) {
        // write code here
        if (str == null || str.length() < 1) {
            return str;
        }

        String[] strings = str.toLowerCase().split(" ");
        Set<Character> set = new HashSet<>(16);
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            for (Character ch: strings[i].toCharArray()) {
                if (!set.contains(ch)) {
                    set.add(ch);
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
