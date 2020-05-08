package com.patterns;

import java.util.List;

/**
 * 过滤器模式-创建标准接口(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:12
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> people);
}
