package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/23 19:13
 */
public class PolymorphicTest {

    public static void main(String[] args) {
        // 输出 22 34 17
        System.out.println(new B().getValue());
    }

    static class A {
        public int value;

        public A (int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {

        public B () {
            super(5);
            setValue(getValue() - 3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}