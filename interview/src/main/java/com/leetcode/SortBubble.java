package com.leetcode;

/**
 * 冒泡排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/10 17:26
 */
public class SortBubble extends Sort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(array);
        printArray(array);
    }
}
