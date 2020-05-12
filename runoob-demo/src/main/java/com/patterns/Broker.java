package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式-创建命令调用Broker类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:20
 */
public class Broker {

    private List<Order> orders = new ArrayList<>();

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrders() {
        for (Order order: orders) {
            order.execute();
        }

        orders.clear();
    }
}
