package com.patterns;

/**
 * 访问者模式-使用ComputerPartDisplayVisitor来显示Computer的组成部分(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 14:33
 */
public class PatternDemoVisitor {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
