package com.patterns;

/**
 * 享元模式-圆形实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:54
 */
public class CircleFlyweight implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public CircleFlyweight(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Circle::draw() [Color: %s, x: %d, y: %d, radius: %d].\n",
                color, x, y, radius);
    }
}
