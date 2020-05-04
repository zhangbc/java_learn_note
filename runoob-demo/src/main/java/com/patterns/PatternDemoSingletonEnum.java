package com.patterns;

/**
 * 单例模式-登记式/静态内部类
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingletonEnum {
    public static void main(String[] args) {
        SingleEnum singleEnum = SingleEnum.INSTANCE;
        singleEnum.showMessage();
    }
}


enum SingleEnum {
    /**
     * 单例实例
     */
    INSTANCE;
    public void showMessage() {
        System.out.println("Hello SingleEnum Object!");
    }
}
