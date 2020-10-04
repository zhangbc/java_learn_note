package com.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1 2 2 4
 * 8
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/14 20:00
 */
public class Main10142 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayStr = scanner.nextLine().split(" ");
        int[] array = new int[4];
        for (int i = 0; i < arrayStr.length; i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }

        Arrays.sort(array);
        if (array[0] == array[3]) {
            System.out.println(array[0] * 4);
        }

        if (array[1] == array[2]) {
            if ((array[3] - array[0]) % 3 == 0) {
                if (array[0] + (array[3] - array[0]) % 3 == array[1]) {
                    System.out.println(array[1] * 4);
                } else {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
