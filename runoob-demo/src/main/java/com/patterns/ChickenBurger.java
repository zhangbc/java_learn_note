package com.patterns;

/**
 *  建造者模式-扩展了的ChickenBurger实体类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:09
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
