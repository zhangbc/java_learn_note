package com.patterns;

/**
 * 抽象工厂模式-创建工厂(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:52
 */
public class AbstractColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }

        String[] instances = new String[] {"RED", "GREEN", "BLUE"};
        if (color.equalsIgnoreCase(instances[0])) {
            return new Red();
        } else if (color.equalsIgnoreCase(instances[1])) {
            return new Green();
        } else if (color.equalsIgnoreCase(instances[2])) {
            return new Blue();
        }

        return null;
    }
}
