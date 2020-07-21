package com.patterns;

/**
 * 传输对象模式--使用StudentBO来演示传输对象模式(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/22 00:13
 */
public class PatternDemoTransferObject {
    public static void main(String[] args) {
        StudentBO studentsObject = new StudentBO();
        for (StudentVO sv: studentsObject.getAllStudents()) {
            System.out.printf("Student: [sno: %d, name: %s].\n", sv.getSno(), sv.getName());
        }

        StudentVO student = studentsObject.getAllStudents().get(0);
        student.setName("Michael");
        studentsObject.updateStudent(student);

        StudentVO sv = studentsObject.getStudent(0);
        System.out.printf("Student: [sno: %d, name: %s].\n", sv.getSno(), sv.getName());
    }
}
