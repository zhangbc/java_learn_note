package com.leetcode;

/**
 * 选择排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/10 17:26
 */
public class SortSelection extends Sort {

    public static void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(array);
        printArray(array);
    }

}
