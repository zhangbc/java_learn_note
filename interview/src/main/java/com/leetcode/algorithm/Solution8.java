package com.leetcode.algorithm;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/18 11:30
 */
public class Solution8 {
    public int myAtoi(String s) {
        if (s == null || s.length() < 1 || isDigital(s.charAt(0), 1)) {
            return 0;
        }

        int sum = 0, begin = 0;
        boolean positive = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '&& begin < 1) {
                continue;
            }

            begin++;
            if (isDigital(s.charAt(i), begin)) {
                return positive ? sum : sum * (-1);
            }

            // 正负数判断
            if (begin == 1 && s.charAt(i) == '-') {
                positive = false;
                continue;
            }

            if (begin == 1 && s.charAt(i) == '+') {
                positive = true;
                continue;
            }

            // 数据溢出
            int number = s.charAt(i) - '0';
            boolean maxOverflow = sum > 0 && positive && (Integer.MAX_VALUE / 10 < sum || Integer.MAX_VALUE - sum * 10 < number);
            boolean minOverflow = sum > 0 && !positive && (Integer.MIN_VALUE / 10 > sum * (-1) || Integer.MIN_VALUE - sum * (-10) > (-1) * number);
            if (maxOverflow || minOverflow) {
                return maxOverflow ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            sum = sum * 10 + number;
        }

        return positive ? sum : sum * (-1);
    }

    /**
     * 判断是否为有效字符
     * @param ch 字符
     * @param i 1：含+/-；其他：不含+/-
     * @return true/false
     */
    private boolean isDigital(char ch, int i) {
        if (Character.isDigit(ch)) {
            return false;
        }

        return i != 1 || (ch != '+' && ch != '-' && ch != ' ');
    }

    public static void main(String[] args) {
        //        "42"
        //        "   -42"
        //        "4193 with words"
        //        "words and 987"
        //        "  -0012a42"
        //        "+-12"
        //        "   +0 123"
        String s = "   +0 123";
        System.out.println(new Solution8().myAtoi(s));
    }
}
