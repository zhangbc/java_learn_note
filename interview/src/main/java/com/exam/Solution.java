package com.exam;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/22 21:05
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param Str string字符串 字符串
     * @param len int整型 字符长度
     * @return int整型
     */
    public int lenSubstring (String Str, int len) {
        int max = 0;
        Set<Character> set;
        for (int i = 0; i < len; i++) {
            set = new HashSet<>(16);
            set.add(Str.charAt(i));
            for (int j = i + 1; j < len; j++) {
                if (set.contains(Str.charAt(j))) {
                    break;
                } else {
                    set.add(Str.charAt(j));
                }
            }
            max = Math.max(max, set.size());
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "accb";
        System.out.println(new Solution().lenSubstring(s, 4));
    }
}
