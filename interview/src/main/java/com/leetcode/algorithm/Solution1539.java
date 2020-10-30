package com.leetcode.algorithm;

/**
 * 1539. 第 k 个缺失的正整数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/21 16:23
 */
public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return 1;
        }

        int i = 0, j = 1;
        while ( i < arr.length) {
            if (k == 0) {
                break;
            }

            if (arr[i] < j) {
                k--;
                i++;
            } else if (arr[i] > j) {
                k--;
                j++;
            } else {
                j++;
                i++;
            }
        }

        while (k > 0) {
            k--;
            j++;
        }

        return j - 1;
    }

    public int findKthPositive2(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return 1;
        }

        int low = 0, high = arr.length;
        while (low < high) {
            int index = (low + high) >> 1;
            int mid = index < arr.length ? arr[index] : Integer.MAX_VALUE;
            if (mid - index - 1 >= k) {
                high = index;
            } else {
                low = index + 1;
            }
        }

        return k + low;
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
        int k = 5;
        System.out.println(new Solution1539().findKthPositive2(array, k));
    }
}
