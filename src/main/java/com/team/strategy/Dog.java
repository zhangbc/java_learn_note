package com.team.strategy;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/18/22 2:41 AM
 **/
public class Dog implements Comparable<Dog> {
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog dog) {
        return Integer.compare(this.food, dog.food);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
