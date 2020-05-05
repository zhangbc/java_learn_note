package com.patterns;

import java.util.Hashtable;

/**
 * 原型模式-创建一个获取实体类的类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 13:58
 */
public class ShapeCache {
    private static Hashtable<String, ShapeProto> shapeMap = new Hashtable<>();

    public static ShapeProto getShape(String shapeId) {
        ShapeProto cache = shapeMap.get(shapeId);
        return (ShapeProto) cache.clone();
    }

    public static void loadCache() {
        CircleProto circle = new CircleProto();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        SquareProto square = new SquareProto();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        RectangleProto rectangle = new RectangleProto();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
