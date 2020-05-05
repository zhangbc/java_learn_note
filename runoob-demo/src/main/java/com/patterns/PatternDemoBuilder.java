package com.patterns;

/**
 *  建造者模式-使用MealBuilder实体类(7)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/5 12:55
 */
public class PatternDemoBuilder {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal: ");
        vegMeal.showItems();
        System.out.printf("Total Cost: %.2f\n\n", vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("None Veg Meal: ");
        nonVegMeal.showItems();
        System.out.printf("Total Cost: %.2f\n", nonVegMeal.getCost());
    }
}
