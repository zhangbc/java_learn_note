package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式-使用不同的标准Criteria和它们的结合来过滤Person对象的列表(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 22:00
 */
public class PatternDemoCriteria {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Robert", "Male", "Single"));
        people.add(new Person("John", "Male", "Married"));
        people.add(new Person("Laura", "Female", "Married"));
        people.add(new Person("Diana", "Female", "Single"));
        people.add(new Person("Mike", "Male", "Single"));
        people.add(new Person("Bobby", "Male", "Single"));
        
        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new CriteriaAnd(single, male);
        Criteria singleOrFemale = new CriteriaOr(single, female);

        System.out.println("Males:");
        printPersons(male.meetCriteria(people));
        
        System.out.println("\nFemales:");
        printPersons(female.meetCriteria(people));
        
        System.out.println("\nSingle Males:");
        printPersons(singleMale.meetCriteria(people));
        
        System.out.println("\nSingle or Females:");
        printPersons(singleOrFemale.meetCriteria(people));
    }

    private static void printPersons(List<Person> people) {
        for (Person p: people) {
            System.out.printf("Person: [Name: %s, Gender: %s, Marital Status: %s].\n",
                    p.getName(), p.getGender(), p.getMaritalStatus());
        }
    }
}
