package com.datastructure;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 17:26
 */
public class SortMerge extends Sort {

    private static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int middle = (int) Math.floor(array.length / 2.0);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        printArray(result);

        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(array);
        printArray(mergeSort(array));
    }

}
