package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/27 00:10
 */
public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length < 1 || B == null || B.length < 1
                || C == null || C.length < 1 || D == null || D.length < 1) {
            return  0;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        int temp;
        for (int k : A) {
            for (int i : B) {
                temp = k + i;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int ans = 0;
        for (int k : C) {
            for (int i : D) {
                temp = -(k + i);
                if (map.containsKey(temp)) {
                    ans += map.get(temp);
                }
            }
        }

        return ans;
    }
}
