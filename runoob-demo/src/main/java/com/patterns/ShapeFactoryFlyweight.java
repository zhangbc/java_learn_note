package com.patterns;

import java.util.HashMap;

/**
 * 享元模式-创建工厂，生成基于实体类的对象(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 14:00
 */
public class ShapeFactoryFlyweight {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        CircleFlyweight circle = (CircleFlyweight) circleMap.get(color);

        if (circle == null) {
            circle = new CircleFlyweight(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }

        return circle;
    }
}
