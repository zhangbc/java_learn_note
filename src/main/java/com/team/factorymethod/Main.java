package com.team.factorymethod;

/**
 * java_learn_note
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 12:46 AM
 **/
public class Main {
    public static void main(String[] args) {
        Movable movable = new Car();
        movable.go();

        movable = new Plane();
        movable.go();

        movable = new CarFactory().create();
        movable.go();
    }
}
