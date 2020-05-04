package com.patterns;

/**
 * 单例模式-获取对象(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:51
 */
public class PatternDemoSingleton {
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }
}
