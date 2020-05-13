package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式-Subject类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:22
 */
public class Subject {
    
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer obj: observers) {
            obj.update();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
}
