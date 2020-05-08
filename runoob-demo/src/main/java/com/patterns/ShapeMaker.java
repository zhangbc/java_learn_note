package com.patterns;

/**
 * 外观模式-创建外观类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:39
 */
public class ShapeMaker {

    private Shape cirlce;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        cirlce = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle() {
        cirlce.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
