package com.leetcode.algorithm;

/**
 * 1534. 统计好三元组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/24 14:56
 */
public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 3, ans = 0;
        if (arr == null || arr.length < count) {
            return ans;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    long d1 = Math.abs(arr[i] - arr[j]),
                            d2 = Math.abs(arr[j] - arr[k]),
                            d3 = Math.abs(arr[i] - arr[k]);
                    if (d1 <= a && d2 <= b && d3 <= c) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 1, 9, 7};
        System.out.println(new Solution1534().countGoodTriplets(arr, 7, 2, 3));
    }
}
