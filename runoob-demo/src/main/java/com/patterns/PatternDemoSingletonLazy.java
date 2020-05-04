package com.patterns;

/**
 * 单例模式-懒汉式，线程安全
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonLazy {
    public static void main(String[] args) {
        SingleLazy singleLazy = SingleLazy.getInstance();
        singleLazy.showMessage();
    }
}


class SingleLazy {
    private static SingleLazy instance = new SingleLazy();

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleLazy() {

    }

    public static synchronized SingleLazy getInstance() {
        if (instance == null) {
            instance = new SingleLazy();
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("Hello SingleLazy Object!");
    }
}
