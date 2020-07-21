package com.patterns;

/**
 * 数据库访问对象模式--使用StudentDao来演示数据访问对象模式(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:49
 */
public class PatternDemoDao {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();

        for (Student student: dao.getAllStudents()) {
            System.out.printf("Student: [Roll No: %d, Name: %s]\n",
                    student.getRollNo(), student.getName());
        }

        Student student = dao.getAllStudents().get(0);
        student.setName("Michael");
        dao.update(student);

        dao.getStudent(0);
        System.out.printf("Student: [Roll No: %d, Name: %s]",
                student.getRollNo(), student.getName());
    }
}
