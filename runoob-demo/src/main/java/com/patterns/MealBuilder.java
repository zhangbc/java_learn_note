package com.patterns;

/**
 *  建造者模式-创建负责创建Meal对象的MealBuilder实体类(6)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:50
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
