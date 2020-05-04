package com.patterns;

/**
 * 抽象工厂模式-绿色实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:14
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
