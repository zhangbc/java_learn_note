package com.team.strategy;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/23/23 1:15 AM
 **/
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog obj1, Dog obj2) {
        return Integer.compare(obj1.food, obj2.food);
    }
}
