package com.patterns;

/**
 * 单例模式-饿汉式
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonNoLazy {
    public static void main(String[] args) {
        SingleNoLazy singleNoLazy = SingleNoLazy.getInstance();
        singleNoLazy.showMessage();
    }
}


class SingleNoLazy {
    private static SingleNoLazy instance = new SingleNoLazy();

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleNoLazy() {

    }

    public static SingleNoLazy getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello SingleNoLazy Object!");
    }
}
