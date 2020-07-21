package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库访问对象模式--创建实现数据访问对象接口的实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:32
 */
public class StudentDaoImpl implements StudentDao {

    List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>(16);
        Student s1 = new Student("Robert", 0);
        Student s2 = new Student("John", 1);
        students.add(s1);
        students.add(s2);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void update(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No: " + student.getRollNo()
                + ", updated in the database.");
    }

    @Override
    public void delete(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No: " + student.getRollNo()
                + ", delete from the database.");
    }
}
