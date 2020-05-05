package com.patterns;

/**
 * 建造者模式-食物条目接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 11:53
 */
public interface Item {
    /**
     * 获取或者设置食物名称
     * @return 食物名称
     */
    String name();

    /**
     * 包装
     * @return 包装结果
     */
    Packing packing();

    /**
     * 获取或者设置食物价格
     * @return 食物价格
     */
    float price();
}
