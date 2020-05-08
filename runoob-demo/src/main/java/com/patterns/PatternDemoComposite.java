package com.patterns;

/**
 * 组合模式-使用Employee类来创建和打印员工的层次结构(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 22:34
 */
public class PatternDemoComposite {
    public static void main(String[] args) {
        Employee ceo = new Employee("John", "CEO", 30000.0);
        Employee headSales = new Employee("Robert", "Head Sales", 20000.0);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000.0);
        Employee clerk1 = new Employee("Laura", "Marketing", 10000.0);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000.0);
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000.0);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000.0);

        ceo.add(headMarketing);
        ceo.add(headSales);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        System.out.println(ceo);
        for (Employee he: ceo.getSubordinates()) {
            System.out.println(he);
            for (Employee e: he.getSubordinates()) {
                System.out.println(e);
            }
        }
    }
}
