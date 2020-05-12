package com.patterns;

/**
 * 命令模式-使用Broker类接受并执行命令(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:24
 */
public class PatternDemoCommand {
    public static void main(String[] args) {

        Stock stock = new Stock();
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}
