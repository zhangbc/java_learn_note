package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 传输对象模式--创建业务对象(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/22 00:04
 */
public class StudentBO {

    List<StudentVO> students;

    public StudentBO() {
        students = new ArrayList<>(16);
        StudentVO sv1 = new StudentVO("Robert", 0);
        StudentVO sv2 = new StudentVO("John", 1);
        students.add(sv1);
        students.add(sv2);
    }

    public void deleteStudent(StudentVO student) {
        students.remove((int)student.getSno());
        System.out.printf("Student: [sno: %d], deleted from database.\n", student.getSno());
    }

    public List<StudentVO> getAllStudents() {
        return students;
    }

    public StudentVO getStudent(int sno) {
        return students.get(sno);
    }

    public void updateStudent(StudentVO student) {
        students.get(student.getSno()).setName(student.getName());
        System.out.printf("Student: [sno: %d], update in the database.\n", student.getSno());
    }
}
