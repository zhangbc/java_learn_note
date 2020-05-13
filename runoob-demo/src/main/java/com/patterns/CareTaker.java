package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式-CareTaker类(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 11:53
 */
public class CareTaker {

    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}
