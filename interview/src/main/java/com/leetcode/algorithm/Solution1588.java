package com.leetcode.algorithm;

/**
 * 1588. 所有奇数长度子数组的和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/30 00:25
 */
public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int length = arr.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += getOddSum(arr, i);
        }

        return sum;
    }

    private int getOddSum(int[] arr, int i) {
        int sum = 0;
        int temp = 0;
        int count = 0;
        for (int j = i; j < arr.length; j++) {
            temp += arr[j];
            count++;
            if (count % 2 == 1) {
                sum += temp;
            }
        }

        return sum;
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int length = arr.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int left = i + 1, right = length - i;
            int left_even = (left + 1) / 2, right_even = (right + 1) / 2;
            int left_odd = left / 2, right_odd = right / 2;
            sum += (left_even * right_even + left_odd * right_odd) * arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int sum = new Solution1588().sumOddLengthSubarrays(nums);
        System.out.println(sum);
    }
}
