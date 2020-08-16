package com.jvm;

/**
 * 字段解析
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/17 01:07
 */
public class FieldResolution {

    interface Interdace0 {
        int number = 0;
    }

    interface Interdace1 extends Interdace0 {
        int number = 1;
    }

    interface Interdace2 {
        int number = 2;
    }

    static class Parent implements Interdace1 {
        public static int number = 3;
    }

    static class Children extends Parent implements Interdace2 {
        /**
         * 若注释掉，会抛出异常：
         * Error:(33, 36) java: 对number的引用不明确
                            com.jvm.FieldResolution.Parent 中的变量 number
                                和 com.jvm.FieldResolution.Interdace2 中的变量 number 都匹配
         */
        public static int number = 4;
    }

    public static void main(String[] args) {
        System.out.println(Children.number);
    }
}
