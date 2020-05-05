package com.patterns;

/**
 * 抽象工厂模式-创建工厂(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:52
 */
public class AbstractShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        String[] instances = new String[] {"CIRCLE", "RECTANGLE", "SQUARE"};
        if (shapeType.equalsIgnoreCase(instances[0])) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase(instances[1])) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase(instances[instances.length - 1])) {
            return new Square();
        }

        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
