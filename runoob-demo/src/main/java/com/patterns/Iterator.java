package com.patterns;

/**
 * 迭代器模式-创建接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 12:55
 */
public interface Iterator {

    /**
     * @return 是否有next
     */
    boolean hasNext();

    /**
     * @return next对象
     */
    Object next();
}
