package com.patterns;

/**
 * 工厂模式-圆形实体类(2)
 * 抽象工厂模式-圆形实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:50
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
