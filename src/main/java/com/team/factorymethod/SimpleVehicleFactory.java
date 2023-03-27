package com.team.factorymethod;

/**
 * 简单工厂：可扩展性不好
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 12:55 AM
 **/
public class SimpleVehicleFactory {
    public Car createCar() {
        return new Car();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
