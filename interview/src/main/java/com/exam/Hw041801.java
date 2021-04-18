package com.exam;

import java.util.Scanner;

/**
 * 找终点
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/18 16:07
 */
public class Hw041801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.valueOf(strings[i]);
        }

        int dst = Integer.MAX_VALUE;
        // 计算第二步开始的最少步数达到终点
        for (int i = 1; i < array.length / 2; i++) {
            int d = getNumber(array, i);
            // 第一步任意，不受限制
            if (d != -1) {
                dst = Math.min(dst, d);
            }
        }

        dst = dst == Integer.MAX_VALUE ? -1 : dst;
        System.out.println(dst);
    }

    private static int getNumber(int[] array, int i) {
        int step = 1;
        while (i < array.length) {
            i += array[i];
            step++;
            if (i == array.length - 1) {
                return step;
            }

            if (i > array.length - 1) {
                return -1;
            }
        }

        return -1;
    }
}
