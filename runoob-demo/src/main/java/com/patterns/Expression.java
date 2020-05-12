package com.patterns;

/**
 * 解释器模式-创建接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:33
 */
public interface Expression {
    public boolean interpret(String context);
}
