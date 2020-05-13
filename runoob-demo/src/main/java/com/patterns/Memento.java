package com.patterns;

/**
 * 备忘录模式-Memento类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:53
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
