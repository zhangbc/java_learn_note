package com.exam;

/**
 * Java 委托实现
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/22 21:39
 */
public class SpaceShipDelegation {

    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    private void right(int velocity) {
        controls.right(velocity);
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public static void main(String[] args) {
        SpaceShipDelegation delegation = new SpaceShipDelegation("NSEA Protector");
        delegation.forward(100);
    }
}


class SpaceShipControls {

    void up(int velocity) {}
    void down(int velocity) {}
    void left(int velocity) {}
    void right(int velocity) {}
    void forward(int velocity) {}
    void back(int velocity) {}
    void turboBoost() {}
}


class DerivedSpaceShip extends SpaceShipControls {

    private String name;
    public DerivedSpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
