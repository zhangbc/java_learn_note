package com.exam;

import java.util.Arrays;

/**
 * 三个层次的继承
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/22 21:29
 */
public class Cartoon extends Drawing {

    public Cartoon() {
        System.out.println("Cartoon constructor.");
    }

    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 5, 4};
        Cartoon cartoon = new Cartoon();

        for (int item: array) {
            System.out.printf("%d ", item);
        }

        array[3] = 10;
        for (int item: array) {
            System.out.printf("%d ", item);
        }
    }
}

class Art {
    Art() {
        System.out.println("Art constructor.");
    }
}


class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor.");
    }
}
