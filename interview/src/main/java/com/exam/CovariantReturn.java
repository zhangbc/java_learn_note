package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 00:22
 */
public class CovariantReturn {

    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}


class Grain {

    @Override
    public String toString() {
        return "Grain";
    }
}


class Wheat extends Grain {

    @Override
    public String toString() {
        return "Wheat";
    }
}


class Mill {

    Grain process() {
        return new Grain();
    }
}


class WheatMill extends Mill {

    @Override
    Wheat process() {
        return new Wheat();
    }
}