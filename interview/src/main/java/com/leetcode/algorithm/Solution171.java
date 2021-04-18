package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 171. Excel 表列序号
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/7/30 23:05
 */
public class Solution171 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            return 0;
        }

        int ans = 0, bit = 26;
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 1; i <= bit; i++) {
            map.put((char)('A' + i - 1), i);
        }

        for (int i = 0; i < columnTitle.length(); i++) {
            ans = ans * bit + map.get(columnTitle.charAt(i));
        }

        return ans;
    }

    public int titleToNumber2(String columnTitle) {
        if (columnTitle == null) {
            return 0;
        }

        int ans = 0, bit = 26;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = ans * bit + columnTitle.charAt(i) - 'A' + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution171 cls = new Solution171();
        System.out.println(cls.titleToNumber("A"));
    }
}
