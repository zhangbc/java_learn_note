package com.team.strategy;

/**
 * design-patterns
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/18/22 2:39 AM
 **/
public interface Comparable<T> {
    /**
     * 比较大小
     * @param obj 比较对象
     * @return 比较结果：-1，0，1
     */
    int compareTo(T obj);
}
