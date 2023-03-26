package com.team.strategy;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/26/23 10:29 PM
 **/
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat obj1, Cat obj2) {
        return Integer.compare(obj2.height, obj1.height);
    }
}
