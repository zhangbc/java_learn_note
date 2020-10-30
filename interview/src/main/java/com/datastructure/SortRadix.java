package com.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/29 16:31
 */
public class SortRadix extends Sort {

    public static void radixSort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int maxDigit = getMaxDigit(array);

        int mod = 10, dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            List<List<Integer>> counter = new ArrayList<>(mod * 2);
            for (int j = 0; j < mod * 2; j++) {
                counter.add(new ArrayList<>(16));
            }

            for (int k : array) {
                int bucket = ((k % mod) / dev) + mod;
                counter.get(bucket).add(k);
            }

            printArrays(counter);

            int pos = 0;
            for (List<Integer> bucket: counter) {
                for (int value: bucket) {
                    array[pos++] = value;
                }
            }
        }
    }

    private static int getMaxDigit(int[] array) {
        int max = getMaxValue(array);
        return getNumberLength(max);
    }

    private static int getNumberLength(int num) {
        if (num == 0) {
            return 1;
        }

        int length = 0;
        for (long i = num; i != 0; i /= 10) {
            length++;
        }

        return length;
    }

    private static int getMaxValue(int[] array) {

        int max = array[0];
        for (int item: array) {
            max = Math.max(max, item);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        printArray(array);
        radixSort(array);
        printArray(array);
    }

}
