package com.patterns;

/**
 * 空对象模式-抽象类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:10
 */
public abstract class AbstractCustomer {
    protected String name;

    /**
     * 判断是否为空对象
     * @return true or false
     */
    public abstract boolean isNil();

    /**
     * 获取对象名称
     * @return 对象名称
     */
    public abstract String getName();
}
