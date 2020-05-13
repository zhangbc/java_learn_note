package com.patterns;

/**
 * 备忘录模式-使用CareTaker与Originator类(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:06
 */
public class PatternDemoMemento {
    public static void main(String[] args) {
        Originator org = new Originator();
        CareTaker care = new CareTaker();
        org.setState("State #1");
        org.setState("State #2");
        care.add(org.saveStateToMemento());
        org.setState("State #3");
        care.add(org.saveStateToMemento());
        org.setState("State #4");

        System.out.println("Current state: " + org.getState());
        org.getSateFromMemento(care.get(0));
        System.out.println("First saved state: " + org.getState());
        org.getSateFromMemento(care.get(1));
        System.out.println("Second saved state: " + org.getState());
    }
}
