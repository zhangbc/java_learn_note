package com.patterns;

/**
 * 空对象模式-CustomerFactory实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:21
 */
public class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};
    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }

        return new NullCustomer();
    }
}
