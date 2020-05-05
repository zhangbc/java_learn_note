package com.patterns;

/**
 * 原型模式-创建扩展了实现Cloneable的抽象类的RectangleProto实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 13:50
 */
public class RectangleProto extends ShapeProto {
    public RectangleProto() {
        type = "RectangleProto";
    }

    @Override
    void draw() {
        System.out.println("Inside RectangleProto::draw() method.");
    }
}
