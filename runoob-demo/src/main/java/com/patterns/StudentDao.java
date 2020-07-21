package com.patterns;

import java.util.List;

/**
 * 数据库访问对象模式--创建数据访问对象接口(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:26
 */
public interface StudentDao {
    /**
     * 获取所有学生信息
     * @return 所有学生信息
     */
    List<Student> getAllStudents();

    /**
     * 根据学号获取学生信息
     * @param rollNo 学号
     * @return 学生信息
     */
    Student getStudent(int rollNo);

    /**
     * 更新学生信息
     * @param student 学生信息
     */
    void update(Student student);

    /**
     * 删除学生记录
     * @param student 学生信息
     */
    void delete(Student student);
}
