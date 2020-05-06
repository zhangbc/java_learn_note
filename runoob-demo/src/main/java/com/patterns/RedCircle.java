package com.patterns;

/**
 * 桥接模式-创建实现DrawApi接口的RedCircle实体桥接实现类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 13:03
 */
public class RedCircle implements DrawApi {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Drawing Circle[color: red, radius: %d, x: %d, y: %d]\n",
                radius, x, y);
    }
}
