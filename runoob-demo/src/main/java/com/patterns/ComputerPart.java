package com.patterns;

/**
 * 访问者模式-定义元素接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:14
 */
public interface ComputerPart {
    /**
     * 接收器方法
     * @param computerPartVisitor 访问者对象
     */
    void accept(ComputerPartVisitor computerPartVisitor);
}
