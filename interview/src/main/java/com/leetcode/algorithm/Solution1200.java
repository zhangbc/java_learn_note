package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 18:32
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>(16);
        if (arr == null || arr.length <= 1) {
            return ans;
        }

        Arrays.sort(arr);
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDist = Math.min(minDist, Math.abs(arr[i] - arr[i - 1]));
        }

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == minDist) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(arr[i -1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}
