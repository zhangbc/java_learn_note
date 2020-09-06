package com.jvm;

/**
 * 单分派和多分派
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 16:43
 */
public class Dispatch {

    static class Tencent {}
    static class Aily {}

    public static class Father {
        public void hardChoice(Tencent arg) {
            System.out.println("Father choose QQ.");
        }

        public void hardChoice(Aily arg) {
            System.out.println("Father choose Aily.");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(Tencent arg) {
            System.out.println("Son choose QQ.");
        }

        @Override
        public void hardChoice(Aily arg) {
            System.out.println("Son choose Aily.");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new Aily());
        son.hardChoice(new Tencent());
    }
}
