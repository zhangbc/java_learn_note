package com.patterns;

/**
 * MVC模式--创建模型(1)
 * 数据库访问对象模式--创建数值对象(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 11:27
 */
public class Student {

    private int rollNo;
    private String name;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
