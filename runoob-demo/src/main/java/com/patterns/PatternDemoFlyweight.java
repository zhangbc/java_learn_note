package com.patterns;

import java.util.Random;

/**
 * 享元模式-使用工厂获取实体类的对象(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 14:06
 */
public class PatternDemoFlyweight {

    private static final String[] COLORS =
            {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        int count = 20;
        for (int i = 0; i < count; i++) {
            CircleFlyweight circle =
                    (CircleFlyweight)ShapeFactoryFlyweight.getCircle(getRandomColor());
            circle.setX(getRandom());
            circle.setY(getRandom());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return COLORS[(int)(Math.random() * COLORS.length)];
    }

    private static int getRandom() {
        double res = Math.random() * 100;
        return (int)(res);
    }
}
