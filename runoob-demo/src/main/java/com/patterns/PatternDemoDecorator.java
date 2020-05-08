package com.patterns;

/**
 * 装饰器模式-   实现装饰器对象(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:21
 */
public class PatternDemoDecorator {
    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border.");
        circle.draw();

        System.out.println("\nCircle of red border.");
        redCircle.draw();

        System.out.println("\nRectangle of red border.");
        redRectangle.draw();
    }
}
