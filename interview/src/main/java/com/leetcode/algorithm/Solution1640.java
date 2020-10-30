package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/22 21:24
 */
public class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        if (arr == null || arr.length < 1 || pieces == null || pieces.length < 1) {
            return false;
        }

        Map<Integer, int[]> map = new HashMap<>(16);
        for (int[] piece: pieces) {
            map.put(piece[0], piece);
        }

        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }

            int[] temp = map.get(arr[i]);
            for (int j = 1; j < temp.length; j++) {
                if (temp[j] != arr[++i]) {
                    return false;
                }
            }

            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        System.out.println(new Solution1640().canFormArray(arr, pieces));
    }
}
