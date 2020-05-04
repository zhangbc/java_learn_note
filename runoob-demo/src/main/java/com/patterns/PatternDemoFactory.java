package com.patterns;

/**
 * 工厂模式-获取实体类对象(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:01
 */
public class PatternDemoFactory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
    }
}
