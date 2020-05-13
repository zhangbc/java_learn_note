package com.patterns;

/**
 * 中介者模式-使用User对象来显示他们之间的通信(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:43
 */
public class PatternDemoMediator {
    public static void main(String[] args) {

        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi, John!");
        john.sendMessage("Hello, Robert!");
    }
}
