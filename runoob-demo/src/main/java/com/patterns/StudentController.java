package com.patterns;

/**
 *  MVC模式--创建控制器(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 11:33
 */
public class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(int rollNo) {
        model.setRollNo(rollNo);
    }

    public int getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}
