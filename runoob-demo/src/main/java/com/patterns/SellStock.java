package com.patterns;

/**
 * 命令模式-实现Order接口的SellStock实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:16
 */
public class SellStock implements Order {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
