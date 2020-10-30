package com.leetcode.algorithm;

/**
 * 125. 验证回文串
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/26 22:25
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        boolean flag;
        while (low < high) {
            flag = Character.isLetterOrDigit(s.charAt(low));
            if (!flag) {
                low++;
                continue;
            }

            flag = Character.isLetterOrDigit(s.charAt(high));
            if (!flag) {
                high--;
                continue;
            }

            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int low = 0, high = s.length() - 1;
        while (low < high) {
            char lowChar = s.charAt(low), highChar = s.charAt(high);
            if (!isLetterOrDigit(lowChar)) {
                low++;
                continue;
            }

            if (!isLetterOrDigit(highChar)) {
                high--;
                continue;
            }

            if (convert(lowChar) != convert(highChar)) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }

    private char convert(char ch) {
        char A = 'A', Z = 'Z';
        if (ch >= A && ch <= Z) {
            ch = (char) (ch + 32);
        }

        return ch;
    }

    private boolean isLetterOrDigit(char ch) {
        // return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        return (((ch >= 48) && (ch <= 57)) || ((ch >=65) && (ch <= 90)) || ((ch >= 97) && (ch <= 122)));
    }
}
