package com.patterns;

/**
 * 观察者模式-Observer抽象类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:23
 */
public abstract class Observer {

    protected Subject subject;

    /**
     * 更新方法
     */
    public abstract void update();
}
