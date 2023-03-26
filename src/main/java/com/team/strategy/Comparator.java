package com.team.strategy;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/18/22 11:37 PM
 **/
public interface Comparator<T> {
    /**
     * 比较大小
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 比较结果：-1，0，1
     */
    int compare(T obj1, T obj2);
}
