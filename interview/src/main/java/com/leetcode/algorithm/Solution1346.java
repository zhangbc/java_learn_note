package com.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 1346. 检查整数及其两倍数是否存在
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 23:28
 */
public class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        int zeroCount = 0;
        Set<Integer> set = new HashSet<>(16);
        for (int num: arr) {
            if (num == 0) {
                zeroCount++;
            } else {
                set.add(num * 2);
            }
        }

        if (zeroCount == 2) {
            return true;
        }

        for (int num: arr) {
            if (set.contains(num)) {
                return true;
            }
        }

        return false;
    }
}
