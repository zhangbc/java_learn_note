package com.leetcode.algorithm;

/**
 * 5605. 检查两个字符串数组是否相等
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 12:22
 */
public class Solution5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null || word1.length < 1 || word2.length < 1) {
            return false;
        }

        return getString(word1).equals(getString(word2));
    }

    private String getString(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String s: words) {
            sb.append(s);
        }

        return sb.toString();
    }
}
