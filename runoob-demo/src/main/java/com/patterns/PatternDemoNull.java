package com.patterns;

/**
 * 空对象模式-使用CustomerFactory，基于客户传递的名字来获取对象(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 13:25
 */
public class PatternDemoNull {
    public static void main(String[] args) {

        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers:");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
