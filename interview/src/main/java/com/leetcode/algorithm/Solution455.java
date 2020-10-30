package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/25 11:54
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length < 1 || g == null || g.length < 1) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, i = 0, j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                ans++;
                j++;
            }

            i++;
        }

        return ans;
    }
}
