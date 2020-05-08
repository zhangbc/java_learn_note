package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式-创建实现Criteria接口的CriteriaAnd实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:20
 */
public class CriteriaAnd implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public CriteriaAnd(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(people);

        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
