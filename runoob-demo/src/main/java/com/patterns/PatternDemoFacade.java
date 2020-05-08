package com.patterns;

/**
 * 外观模式-使用外观类绘制图形(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/8 13:44
 */
public class PatternDemoFacade {
    public static void main(String[] args) {
        ShapeMaker maker = new ShapeMaker();

        maker.drawCircle();
        maker.drawRectangle();
        maker.drawSquare();
    }
}
