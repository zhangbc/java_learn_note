package com.jvm;

/**
 * 非主动使用类字段用例
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/16 21:37
 */
public class NotInitialization {
    public static void main(String[] args) {

        /*
         * 被动使用类字段演示(1)：通过子类引用父类的静态字段，不会导致子类初始化
         * 输出结果：
         *        SuperClass init!
         *        123
         */
        System.out.println(SubClass.value);

        /*
         * 被动使用类字段演示(2)：通过数组定义来引用类，不会触发此类的初始化
         * 输出结果：无
         */
        SuperClass[] sca = new SuperClass[10];

        /*
         * 被动使用类字段演示(3)：常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，
         *                    因此不会触发定义常量的 类的初始化
         * 输出结果: Hello world
         */
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
