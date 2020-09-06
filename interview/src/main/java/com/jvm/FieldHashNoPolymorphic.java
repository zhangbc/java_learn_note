package com.jvm;

/**
 * 字段没有多态性
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 16:22
 */
public class FieldHashNoPolymorphic {

    static class Father {
        private int money = 1;

        public Father() {
            money = 2;
            showMoney();
        }

        public void showMoney() {
            System.out.println("I am Father, I have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMoney();
        }

        @Override
        public void showMoney() {
            System.out.println("I am Son, I have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("The gay has $" + gay.money);
    }
}
