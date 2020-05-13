package com.patterns;

/**
 * 备忘录模式-Originator类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:53
 */
public class Originator {

    private String state;

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getSateFromMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
