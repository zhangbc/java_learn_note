package com.leetcode.algorithm;

import java.util.*;

/**
 * 1331. 数组序号转换
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/24 15:20
 */
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length < 1) {
            return arr;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int index = 1;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            map.put(entry.getKey(), index++);
        }

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }

    public int[] arrayRankTransform2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return arr;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num: arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] bucket = new int[max - min + 1];
        for (int num: arr) {
            bucket[num - min] = 1;
        }

        int[] preSum = new int[bucket.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + bucket[i - 1];
        }

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = preSum[arr[i] - min] + 1;
        }

        return ans;
    }
}
