package com.patterns;

/**
 * 抽象工厂模式-红色实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:14
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
