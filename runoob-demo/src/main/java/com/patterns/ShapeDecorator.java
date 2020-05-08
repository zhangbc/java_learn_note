package com.patterns;

/**
 * 装饰器模式-创建实现Shape接口的ShapeDecorator抽象装饰类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:12
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
