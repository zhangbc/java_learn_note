package com.patterns;

/**
 * 桥接模式-使用DrawApi接口创建ShapeBridge抽象类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/6 13:11
 */
public abstract class ShapeBridge {

    protected DrawApi drawApi;

    protected ShapeBridge(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    /**
     * draw抽象方法
     */
    public abstract void draw();
}
