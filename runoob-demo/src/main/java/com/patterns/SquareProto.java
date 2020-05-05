package com.patterns;

/**
 * 原型模式-创建扩展了实现Cloneable的抽象类的SquareProto实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 13:50
 */
public class SquareProto extends ShapeProto {
    public SquareProto() {
        type = "SquareProto";
    }

    @Override
    void draw() {
        System.out.println("Inside SquareProto::draw() method.");
    }
}
