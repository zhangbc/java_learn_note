package com.patterns;

/**
 * 装饰器模式-创建扩展ShapeDecorator的RedShapeDecorator实体装饰类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:12
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape redBorder) {
        System.out.println("Border color: Red.");
    }
}
