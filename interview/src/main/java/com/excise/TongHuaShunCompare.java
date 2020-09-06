package com.excise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 同花顺考察compare：student按照分数从高到低
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 10:28
 */
public class TongHuaShunCompare {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(16);
        Student student = new Student("tom", 98.5);
        students.add(student);
        student = new Student("san", 87);
        students.add(student);
        student = new Student("andy", 95);
        students.add(student);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student arg0, Student arg1) {
                if (arg0.score > arg1.score) {
                    return -1;
                }
                return 1;
            }
        });

        for (Student stu: students) {
            System.out.println(stu.name + " " + stu.score);
        }
    }

    public static class Student {
        String name;
        double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }
}
