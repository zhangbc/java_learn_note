package com.jvm;

/**
 * 方法动态分派
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 14:16
 */
public class DynamicDispatch {

    static abstract class BaseHuman {
        /**
         * sayHello方法
         */
        protected abstract void sayHello();
    }

    static class Man extends BaseHuman {
        @Override
        protected void sayHello() {
            System.out.println("Man say hello.");
        }
    }

    static class Woman extends BaseHuman {
        @Override
        protected void sayHello() {
            System.out.println("Woman say hello.");
        }
    }

    public static void main(String[] args) {

        BaseHuman man = new Man();
        BaseHuman woman = new Woman();
        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();
    }
}
