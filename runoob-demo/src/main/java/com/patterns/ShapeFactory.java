package com.patterns;

/**
 * 工厂模式-创建工厂(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/4 21:52
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        String[] instances = new String[] {"CIRCLE", "RECTANGLE", "SQUARE"};
        if (shapeType.equalsIgnoreCase(instances[0])) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase(instances[1])) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase(instances[2])) {
            return new Square();
        }

        return null;
    }
}
