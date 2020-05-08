package com.patterns;

import java.util.List;

/**
 * 过滤器模式-创建实现Criteria接口的CriteriaOr实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:20
 */
public class CriteriaOr implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public CriteriaOr(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(people);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(people);

        for (Person p: otherCriteriaItems) {
            if (!firstCriteriaItems.contains(p)) {
                firstCriteriaItems.add(p);
            }
        }

        return firstCriteriaItems;
    }
}
