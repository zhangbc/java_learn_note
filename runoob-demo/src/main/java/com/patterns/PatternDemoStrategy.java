package com.patterns;

/**
 * 策略模式-使用Context来查看当它改变策略Strategy时的行为变化(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:46
 */
public class PatternDemoStrategy {
    public static void main(String[] args) {

        ContextStrategy context = new ContextStrategy(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new ContextStrategy(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new ContextStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        context = new ContextStrategy(new OperationDivision());
        System.out.println("10 / 5 = " + context.executeStrategy(10, 5));
    }
}
