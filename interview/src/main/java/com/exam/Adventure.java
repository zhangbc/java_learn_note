package com.exam;

/**
 * 多接口结合的实现
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 14:47
 */
public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
    }
}


interface CanFight {
    void fight();
}


interface CanSwim {
    void swim();
}


interface CanFly {
    void fly();
}


class ActionCharacter {
    public void fight() {}
}


class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
    public void swim() {}

    public void fly() {}
}