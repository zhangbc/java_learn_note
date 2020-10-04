package com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/29 16:31
 */
public class SortBucket extends Sort {

    public static void bucketSort(int[] array) {

        if (array == null || array.length <= 1) {
            return;
        }

        int max = array[0], min = array[0];
        for (int item: array) {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }

        int bucketNumber = (max - min) / array.length + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketNumber);
        for (int i = 0; i < bucketNumber; i++) {
            buckets.add(new ArrayList<>(16));
        }

        for (int item: array) {
            int num = (int) Math.floor((double) (item - min) / array.length);
            buckets.get(num).add(item);
        }

        printArrays(buckets);

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        printArrays(buckets);

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                array[index++] = integer;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 8, 7, 1, 25, 2, 2, 27, 39, 29, 49, 8, 2, 1, 4, 2, 4, 6, 9, 2, 50};
        printArray(array);
        bucketSort(array);
        printArray(array);
    }

}
