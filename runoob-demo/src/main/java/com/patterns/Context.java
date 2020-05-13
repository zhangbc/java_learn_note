package com.patterns;

/**
 * 状态模式-Context实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:56
 */
public class Context {

    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
