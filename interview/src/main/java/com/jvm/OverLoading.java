package com.jvm;

import java.io.Serializable;

/**
 * 重载方法匹配优先级
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 13:46
 */
public class OverLoading {

    public static void sayHello(Object arg) {
        System.out.println("Hello Object.");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello int.");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long.");
    }

    public static void sayHello(Integer arg) {
        System.out.println("Hello Integer.");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello Character.");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello char.");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char... .");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable.");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
