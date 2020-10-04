package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 17:02
 */
public class Solution10174 {

    public int[] nthResultOfQuickSort (int[] array, int n) {
        // write code here
        if (array == null || array.length < 1) {
            return array;
        }

        quickSort(array, n);
        return array;
    }

    public void quickSort(int[] array, int n) {
        if (array == null || array.length < 1 || n < 0) {
            return;
        }

        quickingSort(array, 0, array.length - 1, n);
    }

    private void quickingSort(int[] array, int low, int high, int n) {
        if (low < high && n > 0) {
            int pos = partition(array, low, high);
            quickingSort(array, low, pos - 1, n - 1);
            quickingSort(array, pos + 1, high, n - 1);
        }
    }

    private int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && array[high] >= key) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= key) {
                low++;
            }
            array[high] = array[low];
        }

        array[low] = key;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {42,35,63,96,56,11,17,42,88};
        printArray(array);
        new Solution10174().quickSort(array, 0);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int item: array) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
}
