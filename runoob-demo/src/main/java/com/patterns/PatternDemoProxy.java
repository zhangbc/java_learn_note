package com.patterns;

/**
 * 代理模式-使用ProxyImage来获取RealImage类的对象(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 11:22
 */
public class PatternDemoProxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        image.display();
        image.display();
    }
}
