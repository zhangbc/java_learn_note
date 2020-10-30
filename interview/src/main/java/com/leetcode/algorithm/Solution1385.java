package com.leetcode.algorithm;

/**
 * 1385. 两个数组间的距离值
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 22:11
 */
public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        if (arr1 == null || arr1.length < 1 || arr2 == null || arr2.length < 1 || d < 1) {
            return 0;
        }

        int ans = 0;
        for (int num: arr1) {
            if (getMinDistance(num, arr2) > d) {
                ans++;
            }
        }

        return ans;
    }

    private long getMinDistance(int num, int[] arr2) {
        int distance = Math.abs(arr2[0] - num);
        for (int i = 1; i < arr2.length; i++) {
            distance = Math.min(distance, Math.abs(num - arr2[i]));
        }

        return distance;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 3}, arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        System.out.println(new Solution1385().findTheDistanceValue(arr1, arr2, d));
    }
}
