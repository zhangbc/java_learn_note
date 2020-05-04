package com.patterns;

/**
 * 工厂模式-创建抽象工厂(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:52
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
