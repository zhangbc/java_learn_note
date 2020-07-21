package com.patterns;

/**
 * 策略模式-接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:35
 */
public interface Strategy {
    /**
     * 操作运算
     * @param num1 操作数1
     * @param num2 操作数2
     * @return 返回结果
     */
    int doOperation(int num1, int num2);
}
