package com.patterns;

/**
 * 桥接模式-创建实现ShapeBridge抽象类的CircleBridge实体类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 13:11
 */
public class CircleBridge extends ShapeBridge {

    private int x, y, radius;

    public CircleBridge(int x, int y, int radius, DrawApi drawApi) {
        super(drawApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.drawCircle(radius, x, y);
    }
}
