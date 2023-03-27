package com.team.abstractfactory;

/**
 * java_learn_note
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 1:07 AM
 **/
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();

        Ak47 ak47 = new Ak47();
        ak47.shoot();

        Bread bread = new Bread();
        bread.printName();

        AbstractFactory factory = new ModernFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();

        Weapon weapon = factory.createWeapon();
        weapon.shoot();

        Food food = factory.createFood();
        food.printName();
    }
}
