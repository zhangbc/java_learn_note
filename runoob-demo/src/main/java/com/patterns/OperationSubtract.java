package com.patterns;

/**
 * 策略模式-实现接口的OperationSubtract实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:37
 */
public class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
