package com.exam;

/**
 * 继承和初始化
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/23 15:37
 */
public class Beetle extends Insect {

    private int k = printInit("Beetle.k initialized.");

    public Beetle() {
        System.out.println("k = " + k + ", j = " + j);
    }

    private static int x2 = printInit("Static Beetle.x2 initialized.");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        new Beetle();
    }
}


class Insect {

    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("Static Insect.x1 initialized.");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}