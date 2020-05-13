package com.patterns;

/**
 * 访问者模式-实现元素接口的Keyboard实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:17
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
