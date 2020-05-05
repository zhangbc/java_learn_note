package com.patterns;

/**
 * 原型模式-使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 14:09
 */
public class PatternDemoPrototype {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        ShapeProto cloneCircle = ShapeCache.getShape("1");
        System.out.println("Shape: " + cloneCircle.getType());

        ShapeProto cloneSquare = ShapeCache.getShape("2");
        System.out.println("Shape: " + cloneSquare.getType());

        ShapeProto cloneRectangle = ShapeCache.getShape("3");
        System.out.println("Shape: " + cloneRectangle.getType());

    }
}
