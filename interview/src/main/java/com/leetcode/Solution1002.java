package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找常用字符
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/14 10:57
 */
public class Solution1002 {
    public List<String> commonChars(String[] A) {
        List<String> common = new ArrayList<>(16);
        if (A == null || A.length <= 1) {
            return common;
        }

        String commonStr = getCommon(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            commonStr = getCommon(commonStr, A[i]);
        }

        for (int i = 0; i < commonStr.length(); i++) {
            common.add(String.valueOf(commonStr.charAt(i)));
        }

        return common;
    }

    private String getCommon(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        int i = 0, j = 0;
        while (i < aa.length && j < bb.length) {
            if (aa[i] == bb[j]) {
                sb.append(aa[i]);
                i++;
                j++;
            } else if (aa[i] < bb[j]) {
                i++;
            } else {
                j++;
            }
        }

        return sb.toString();
    }
}
