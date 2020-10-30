package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 20:49
 */
public class Solution1619 {
    public double trimMean(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0.0;
        }

        int number = (int) Math.round(arr.length * 0.05);
        Arrays.sort(arr);
        long sum = 0;
        for (int i = number; i < arr.length - number; i++) {
            sum += arr[i];
        }

        return arr.length - number * 2 == 0 ? 0 : (double) sum / (arr.length - number * 2);
    }
}
