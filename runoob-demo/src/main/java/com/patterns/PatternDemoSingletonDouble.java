package com.patterns;

/**
 * 单例模式-双检锁/双重校验锁
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonDouble {
    public static void main(String[] args) {
        SingleDouble singleDouble = SingleDouble.getInstance();
        singleDouble.showMessage();
    }
}


class SingleDouble {
    private volatile static SingleDouble instance;

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleDouble() {

    }

    public static SingleDouble getInstance() {
        if (instance == null) {
            synchronized (SingleDouble.class) {
                if (instance == null) {
                    instance = new SingleDouble();
                }
            }
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("Hello SingleDouble Object!");
    }
}
