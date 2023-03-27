package com.team.factorymethod;

import com.team.strategy.Cat;

/**
 * java_learn_note
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 12:58 AM
 **/
public class CarFactory {
    public Movable create() {
        System.out.println("A new car created!");
        return new Car();
    }
}
