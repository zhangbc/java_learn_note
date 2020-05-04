package com.patterns;

/**
 * 单例模式-懒汉式，线程不安全
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonLazyNone {
    public static void main(String[] args) {
        SingleLazyNone singleLazyNone = SingleLazyNone.getInstance();
        singleLazyNone.showMessage();
    }
}


class SingleLazyNone {
    private static SingleLazyNone instance = new SingleLazyNone();

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleLazyNone() {

    }

    public static SingleLazyNone getInstance() {
        if (instance == null) {
            instance = new SingleLazyNone();
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("Hello SingleLazyNone Object!");
    }
}
