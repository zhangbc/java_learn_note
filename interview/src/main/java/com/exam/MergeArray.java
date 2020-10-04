package com.exam;

import java.util.*;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/22 20:36
 */
public class MergeArray {
    static int cnt = 6;
    static{
        cnt += 9;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] arrays = sc.nextLine().split(" ");
//
//        int[] array1 = generateArray(arrays[0]);
//        int[] array2 = generateArray(arrays[1]);
//
//        List<Integer> array = merge(array1, array2);
//        for (Integer integer : array) {
//            System.out.printf("%d ", integer);
//        }
        System.out.println(3 >> 1);
        System.out.println(cnt);
        split(12);

    }

    static{
        cnt /= 3;
    }

    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0) {
                System.out.print(split((number + 1) / 2));
            }
            System.out.print(split(number / 2));
        }
        return number;
    }

    private static int[] generateArray(String array) {
        String[] strings = array.split(",");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }

        return result;
    }

    public static List<Integer> merge(int[] array1, int[] array2) {
        List<Integer> array = new ArrayList<>(16);
        int i = array1.length - 1, j = array2.length - 1;
        while (i >= 0 && j >= 0) {
            if (array1[i] <= array2[j]) {
                insertArray(array, array2[j]);
                j--;
            } else {
                insertArray(array, array1[i]);
                i--;
            }
        }

        while (i >= 0) {
            insertArray(array, array1[i--]);
        }

        while (j >= 0) {
            insertArray(array, array2[j--]);
        }

        return array;
    }

    private static void insertArray(List<Integer> array, int i) {
        if (array.size() > 0) {
            if (i != array.get(0)) {
                array.add(0, i);
            }
        } else {
            array.add(0, i);
        }
    }
}
