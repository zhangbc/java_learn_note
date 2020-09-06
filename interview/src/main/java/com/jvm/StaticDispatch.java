package com.jvm;

/**
 * 方法静态分派
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/21 23:28
 */
public class StaticDispatch {

    static abstract class BaseHuman {

    }

    static class Man extends BaseHuman {

    }

    static class Woman extends BaseHuman {

    }

    public void sayHello(BaseHuman guy) {
        System.out.println("Hello, guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello, gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello, lady!");
    }

    public static void main(String[] args) {
        BaseHuman man = new Man();
        BaseHuman woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);

        // 改进代码
        dispatch.sayHello((Man) man);
        dispatch.sayHello((Woman) woman);
    }
}
