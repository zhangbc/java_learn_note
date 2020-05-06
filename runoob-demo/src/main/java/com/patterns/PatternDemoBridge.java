package com.patterns;

/**
 * 桥接模式-使用ShapeBridge与DrawApi画出不同颜色的圆(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 13:19
 */
public class PatternDemoBridge {
    public static void main(String[] args) {
        ShapeBridge redCircle = new CircleBridge(100, 100, 10, new RedCircle());
        ShapeBridge greenCircle = new CircleBridge(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
