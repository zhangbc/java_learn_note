package com.datastructure;

/**
 * 希尔排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 17:26
 */
public class SortShell extends Sort {

    private static void shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int dk = 1;
        while (dk < array.length) {
            dk = dk * 3 + 1;
        }

        while (dk > 0) {
            for (int i = dk; i < array.length; i++) {
                int temp = array[i];
                int j = i - dk;
                while (j >= 0 && array[j] > temp) {
                    array[j + dk] = array[j];
                    j -= dk;
                }

                array[j + dk] = temp;
            }

            dk = (int) Math.floor((double) dk / 3);
            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(array);
        printArray(array);
    }

}
