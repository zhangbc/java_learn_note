package com.patterns;

/**
 * MVC模式--创建视图(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 11:29
 */
public class StudentView {
    public void printStudentDetails(String name, int rollNo) {
        System.out.printf("Student: \nRoll No: %d\tName: %s\n", rollNo, name);
    }
}
