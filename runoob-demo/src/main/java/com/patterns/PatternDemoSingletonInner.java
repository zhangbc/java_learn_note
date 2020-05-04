package com.patterns;

/**
 * 单例模式-登记式/静态内部类
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonInner {
    public static void main(String[] args) {
        SingleInner singleInner = SingleInner.getInstance();
        singleInner.showMessage();
    }
}


class SingleInner {
    private static class SingletonHolder {
        private static final SingleInner INSTANCE = new SingleInner();
    }

    /**
     * 构造函数私有化，确保不会外部被实例化
     */
    private SingleInner() {

    }

    public static final SingleInner getInstance() {

        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello SingleInner Object!");
    }
}
