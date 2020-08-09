package com.jvm;


/**
 * String.intern()返回引用的测试
 * 在JDK6中运行，会得到两个false，而在JDK7中运行，会得到一个true和一个false。
 * 产生差异的原因是：
 * 在JDK6中， intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池中存储，
 * 返回的也是永久代里面这个字符串实例的引用，而由StringBuilder创建的字符串对象实例
 * 在Java堆上， 所以必然不可能是同一个引用， 结果将返回false。
 * JDK7的intern()方法实现不需要再拷贝字符串的实例到永久代，既然字符串常量池已经移到Java堆中，
 * 那只需要在常量池里记录一下首次出现的实例引用即可，因此intern()返回的引用和由StringBuilder
 * 创建的那个字符串实例就是同一个。 而对str2比较返回false，这是因为“java”这个字符串在执行
 * String-Builder.toString()之前就已经出现过，字符串常量池中已经有它的引用，不符合intern()
 * 方法要求“首次遇到”的原则， “计算机软件”这个字符串则是首次出现的，因此结果返回true。
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/7/19 14:09
 **/
public class RuntimeConstantPoolOOMTest {

    public static void main(String[] args) {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
