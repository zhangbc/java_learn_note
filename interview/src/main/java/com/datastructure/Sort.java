package com.datastructure;

import java.util.List;

/**
 * 排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/27 17:26
 */
public class Sort {

    static void printArray(int[] array) {
        for (int item : array) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    static void printArrays(List<List<Integer>> arrays) {
        for (List<Integer> array: arrays) {
            System.out.print("[ ");
            for (Integer item: array) {
                System.out.printf("%d ", item);
            }
            System.out.print("]");
        }

        System.out.println();
    }
}
