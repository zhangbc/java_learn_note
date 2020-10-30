package com.datastructure;

/**
 * 快速排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/10 17:26
 */
public class SortQuick extends Sort {

    private static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length <= 1) {
            return;
        }

        if (low < high) {
            int pos = partition(array, low, high);
            printArray(array);
            quickSort(array, low, pos - 1);
            quickSort(array, pos + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && Math.abs(array[high]) >= Math.abs(key)) {
                high--;
            }
            array[low] = array[high];

            while (low < high && Math.abs(array[low]) <= Math.abs(key)) {
                low++;
            }
            array[high] = array[low];
        }

        array[low] = key;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

}
