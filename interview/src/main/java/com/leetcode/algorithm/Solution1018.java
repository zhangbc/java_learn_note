package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/27 12:33
 */
public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<>(16);
        if (A == null || A.length < 1) {
            return answer;
        }

        int sum = 0;
        for (int j : A) {
            sum = (sum * 2 + j) % 5;
            answer.add(sum == 0);
        }

        return answer;
    }
}
