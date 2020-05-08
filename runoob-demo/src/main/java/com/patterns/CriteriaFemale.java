package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式-创建实现Criteria接口的CriteriaFemale实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:20
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person p: people) {
            String female = "FEMALE";
            if (p.getGender().equalsIgnoreCase(female)) {
                femalePersons.add(p);
            }
        }

        return femalePersons;
    }
}
