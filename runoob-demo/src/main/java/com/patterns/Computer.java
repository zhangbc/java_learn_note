package com.patterns;

/**
 * 访问者模式-实现元素接口的Computer实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:17
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }

        computerPartVisitor.visit(this);
    }
}
