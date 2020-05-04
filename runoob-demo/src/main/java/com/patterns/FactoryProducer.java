package com.patterns;

/**
 * 抽象工厂模式-创造器/生成器(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 22:27
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        String[] choices = new String[] {"SHAPE", "COLOR"};
        if (choice.equalsIgnoreCase(choices[0])) {
            return new AbstractShapeFactory();
        } else if (choice.equalsIgnoreCase(choices[1])) {
            return new AbstractColorFactory();
        } else {
            return null;
        }
    }
}
