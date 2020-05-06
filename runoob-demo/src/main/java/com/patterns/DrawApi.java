package com.patterns;

/**
 * 桥接模式-接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 13:00
 */
public interface DrawApi {
    /**
     * 画图
     * @param radius 半径
     * @param x 长
     * @param y 宽
     */
    void drawCircle(int radius, int x, int y);
}
