package com.exam;

import java.util.stream.Stream;

/**
 * 多态实现
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 23:55
 */
public class Shapes {

    public static void main(String[] args) {
        Stream.of(new Circle(), new Square(), new Triangle()).forEach(Shape::draw);
    }
}

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}


class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}


class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}


class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}