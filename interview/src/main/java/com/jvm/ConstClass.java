package com.jvm;

/**
 * 常量类
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/16 21:49
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "Hello world";
}
