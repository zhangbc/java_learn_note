package com.datastructure;


/**
 * 计数排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/29 17:26
 */
public class SortCounting extends Sort {

    private static void countSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int maxValue = getMaxValue(array);
        countingSort(array, maxValue);
    }

    private static void countingSort(int[] array, int maxValue) {
        int bucketLength = maxValue + 1;
        int[] bucket = new int[bucketLength];

        for (int val: array) {
            bucket[val]++;
        }

        printArray(bucket);

        int index = 0;
        for (int i = 0; i < bucketLength; i++) {
            while (bucket[i] > 0) {
                array[index++] = i;
                bucket[i]--;
            }
        }
    }

    private static int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2};
        printArray(array);
        countSort(array);
        printArray(array);
    }

}
