package com.patterns;

/**
 *  空对象模式-实现抽象类的NullCustomer实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:16
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
