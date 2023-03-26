package com.team.strategy;

/**
 * 策略模式 - Cat 类
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/18/22 1:31 AM
 **/
public class Cat implements Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat cat) {
        return Integer.compare(this.weight, cat.weight);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
