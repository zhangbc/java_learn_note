package com.datastructure;


/**
 * 堆排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/29 17:26
 */
public class SortHeap extends Sort {

    private static void headSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;
        buildHeap(array);
        printArray(array);
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            length--;
            heapify(array, 0, length);
            printArray(array);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void heapify(int[] array, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, length);
        }
    }

    private static void buildHeap(int[] array) {
        int i = (int) Math.floor(array.length / 2.0);
        while (i >= 0) {
            heapify(array, i, array.length);
            i--;
        }
    }

    public static void main(String[] args) {
        int[] array = {91, 60, 96, 13, 35, 65, 46, 65, 10, 30, 20, 77, 81, 22};
        headSort(array);
        printArray(array);
    }

}
