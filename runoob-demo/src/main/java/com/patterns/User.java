package com.patterns;

/**
 * 中介者模式-User类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:36
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
