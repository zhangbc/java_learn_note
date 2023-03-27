package com.team.abstractfactory;

/**
 * java_learn_note
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 3/27/23 11:08 PM
 **/
public abstract class AbstractFactory {
    /**
     * create Food
     * @return Food
     */
    abstract Food createFood();

    /**
     * create Weapon
     * @return Weapon
     */
    abstract Weapon createWeapon();

    /**
     * create Vehicle
     * @return Vehicle
     */
    abstract Vehicle createVehicle();
}
