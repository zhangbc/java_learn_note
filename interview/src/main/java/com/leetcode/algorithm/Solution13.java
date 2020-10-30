package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 17:55
 */
public class Solution13 {
    public int romanToInt(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int length = s.length();
        int i = 0;
        while (i < length) {
            if (s.charAt(i) == 'I') {
                if (i + 1 < length && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    ans += (s.charAt(i + 1) == 'V' ? 4 : 9);
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i++));
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < length && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    ans += (s.charAt(i + 1) == 'L' ? 40 : 90);
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i++));
                }
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < length && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    ans += (s.charAt(i + 1) == 'D' ? 400 : 900);
                    i += 2;
                } else {
                    ans += map.get(s.charAt(i++));
                }
            } else {
                ans += map.get(s.charAt(i++));
            }
        }

        return ans;
    }

    public int romanToInt2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int ans = 0, pre = getValue(s.charAt(0));
        int length = s.length();
        for (int i = 1; i < length; i++) {
            int num = getValue(s.charAt(i));
            if (pre < num) {
                ans -= pre;
            } else {
                ans += pre;
            }

            pre = num;
        }

        return ans + pre;
    }

    private int getValue(char ch) {
        switch (ch){
            case 'I' :
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;
            default:
                return 0;
        }
    }
}
