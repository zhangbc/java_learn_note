package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式-创建带有Item对象的Meal实体类(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:42
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item: items) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        for (Item item: items) {
            System.out.printf("Item: %s, Packing: %s, Price: %.2f\n",
                    item.name(), item.packing().pack(), item.price());
        }
    }
}
