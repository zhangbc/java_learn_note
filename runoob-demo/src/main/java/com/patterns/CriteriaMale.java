package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式-创建实现Criteria接口的CriteriaMale实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:20
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> malePersons = new ArrayList<>();
        for (Person p: people) {
            String male = "MALE";
            if (p.getGender().equalsIgnoreCase(male)) {
                malePersons.add(p);
            }
        }

        return malePersons;
    }
}
