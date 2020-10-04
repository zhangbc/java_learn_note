package com.leetcode;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/16 09:24
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length < 1) {
            return A;
        }

        int[] array = new int[A.length];
        int i = 0, low = 0, high = A.length - 1;
        while (low < high) {
            if (A[low] < 0) {
                low++;
            }

            if (A[high] >= 0) {
                high--;
            }
        }

        if (A[low] >= 0) {
            high = low;
            low -= 1;
        } else {
            high = low + 1;
        }

        while (low >= 0 || high < A.length) {
            if (low >= 0) {
                if (high < A.length) {
                    if (Math.abs(A[low]) <= Math.abs(A[high])) {
                        array[i++] = (int) Math.pow(A[low], 2);
                        low--;
                    } else {
                        array[i++] = (int) Math.pow(A[high], 2);
                        high++;
                    }
                } else {
                    array[i++] = (int) Math.pow(A[low], 2);
                    low--;
                }
            } else {
                array[i++] = (int) Math.pow(A[high], 2);
                high++;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array1 = {-3, -2, 0};
        int[] array2 = {-1, 2, 2};
        // int[] array = {-49,-39,-35,-35,-33,-33,-32,-31,-27,-24,-22,-14,-9,-8,-7,0,0,3,4,5,6,6,6,11,12,13,13,16,16,18,22,23,25,25,26,28,29,29,30,31,32,35,43,45,45,45,45,45,49,50};
        int[] arr = new Solution977().sortedSquares(array1);
        int[] arr2 = new Solution977().sortedSquares(array2);
        // new Solution977().quickSort(array, 0, array.length - 1);
        for (int i: arr2) {
            System.out.printf("%d ", i);
        }
    }
}
