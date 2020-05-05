package com.patterns;

/**
 * 工厂模式-创建抽象工厂(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:52
 */
public abstract class AbstractFactory {
    /**
     * 获取颜色创建其实体对象
     * @param color 颜色
     * @return 颜色对象
     */
    public abstract Color getColor(String color);


    /**
     * 获取形状创建其实体对象
     * @param shape 形状
     * @return 形状对象
     */
    public abstract Shape getShape(String shape);
}
