package com.patterns;

/**
 * 策略模式-Context类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:43
 */
public class ContextStrategy {

    private Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
