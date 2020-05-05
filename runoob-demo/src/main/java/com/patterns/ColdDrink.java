package com.patterns;

/**
 *  建造者模式-Item接口抽象实现类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:09
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 抽象实现类
     * @return 价格
     */
    @Override
    public abstract float price();
}
