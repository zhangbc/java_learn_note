package com.patterns;

/**
 * 访问者模式-访问者接口(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:23
 */
public interface ComputerPartVisitor {
    /**
     * Computer访问方法
     * @param computer Computer
     */
    void visit(Computer computer);

    /**
     * Mouse访问方法
     * @param mouse Mouse
     */
    void visit(Mouse mouse);

    /**
     * Keyboard访问方法
     * @param keyboard Keyboard
     */
    void visit(Keyboard keyboard);

    /**
     * Monitor访问方法
     * @param monitor Monitor
     */
    void visit(Monitor monitor);
}
