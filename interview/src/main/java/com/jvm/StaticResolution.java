package com.jvm;

/**
 * 方法静态解析
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/21 23:01
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
