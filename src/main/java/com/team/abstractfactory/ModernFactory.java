package com.team.abstractfactory;

/**
 * java_learn_note
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 11:33 PM
 **/
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }
}
