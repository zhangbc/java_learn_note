package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/6 10:55
 */
public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]);
        }

        Arrays.sort(map);

        for (int i = 0; i < map.length; i++) {
            map[i] %= 100000;
        }

        return map;
    }
}
