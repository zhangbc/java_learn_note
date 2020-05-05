package com.patterns;

/**
 *  建造者模式-扩展了的Coke实体类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:09
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
