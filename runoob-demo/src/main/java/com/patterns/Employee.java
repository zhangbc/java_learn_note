package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式-创建Employee类，该类带有Employee对象的列表(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 22:27
 */
public class Employee {

    private String name;
    private String dept;
    private double salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return String.format("Employee: [Name: %s, dept: %s, salary: %.2f]",
                name, dept, salary);
    }
}
