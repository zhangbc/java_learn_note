package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 10:35
 */
public interface InterfaceJava8 {

    void f1();
    void f2();

    default void newFunc() {
        System.out.println("Java 8 Interface default method.");
    }
}
