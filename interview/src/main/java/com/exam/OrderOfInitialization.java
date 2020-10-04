package com.exam;

/**
 * 初始化的顺序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/21 10:31
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House(1);
        house.f();

        house = new House();
        house.f();
    }
}


class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}


class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("House() ");
        w3 = new Window(33);
    }

    House(int i) {
        System.out.println("House(): " + i);
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}