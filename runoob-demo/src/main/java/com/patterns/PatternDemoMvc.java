package com.patterns;

/**
 * MVC模式--使用StudentController方法来演示MVC(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 11:43
 */
public class PatternDemoMvc {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("John");
        controller.setStudentRollNo(30);
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("Robert", 20);
    }
}
