package com.leetcode;

/**
 * 844. 比较含退格的字符串
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/19 20:12
 */
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int si = 0, sj = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    i--;
                    si++;
                } else if (si > 0) {
                    i--;
                    si--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    j--;
                    sj++;
                } else if (sj > 0) {
                    j--;
                    sj--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxj###tw";
        System.out.println(new Solution844().backspaceCompare(s, t));
    }
}
