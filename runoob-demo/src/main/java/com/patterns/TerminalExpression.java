package com.patterns;

/**
 * 解释器模式-创建实现接口的TerminalExpression实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:36
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
