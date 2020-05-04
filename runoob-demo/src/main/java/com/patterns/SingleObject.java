package com.patterns;

/**
 * 单例模式-创建单例对象(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:47
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleObject() {

    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Single Object!");
    }
}
