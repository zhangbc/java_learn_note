package com.leetcode;

/**
 * 925. 长按键入
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/21 09:21
 */
public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }

        int i = 0, j = 0;
        char temp = name.charAt(0);
        while (i < name.length()) {
            // typed过短
            if (j == typed.length()) {
                return false;
            }

            if (name.charAt(i) == typed.charAt(j)) {
                temp = name.charAt(i);
                i++;
                j++;
            } else if (temp == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        // typed超长
        while (j < typed.length()) {
            if (temp == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String name = "alex", typed = "aaleex";
        System.out.println(new Solution925().isLongPressedName(name, typed));
    }
}
