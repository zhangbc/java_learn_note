package com.patterns;

/**
 * 命令模式-请求Stock类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:11
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.printf("Stock [Name: %s, Quantity: %d] bought.\n",
                name, quantity);
    }

    public void sell() {
        System.out.printf("Stock [Name: %s, Quantity: %d] sold.\n",
                name, quantity);
    }
}
