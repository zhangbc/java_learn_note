package com.leetcode;

/**
 * 直接插入排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/10 17:26
 */
public class SortInsert extends Sort {

    public static void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int i, j, key;
        for (i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                key = array[i];
                array[i] = array[i - 1];
                for (j = i - 1; j >= 0 && key < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = key;
            }

            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSort(array);
        printArray(array);
    }
}
