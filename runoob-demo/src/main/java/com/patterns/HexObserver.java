package com.patterns;

/**
 * 观察者模式-实现Observer抽象类的HexObserver实体类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:30
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
