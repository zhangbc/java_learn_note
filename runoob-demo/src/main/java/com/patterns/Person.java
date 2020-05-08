package com.patterns;

/**
 * 过滤器模式-创建应用标准的类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/7 20:02
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
