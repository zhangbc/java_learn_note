package com.exam;

import java.util.Objects;

/**
 * User 类
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/18 12:54
 */
public class User {
    private String name;
    private  int age;

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User)obj;
        return this.name.equals(user.name) && this.age == user.age;
    }
}
