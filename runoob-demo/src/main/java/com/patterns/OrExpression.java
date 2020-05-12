package com.patterns;

/**
 * 解释器模式-创建实现接口的OrExpression实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:36
 */
public class OrExpression implements Expression {

    private Expression expOne = null;
    private Expression expTwo = null;

    public OrExpression(Expression expOne, Expression expTwo) {
        this.expOne = expOne;
        this.expTwo = expTwo;
    }

    @Override
    public boolean interpret(String context) {
        return expOne.interpret(context) || expTwo.interpret(context);
    }
}
