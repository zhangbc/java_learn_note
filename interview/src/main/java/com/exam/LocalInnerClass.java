package com.exam;

/**
 * 局部内部类与匿名内部类的创建比较
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 20:22
 */
public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.printf("%s", name);
                return count++;
            }
        }

        return new LocalCounter();
    }

    Counter getAnonymousCounter(final String name) {
        return new Counter() {
            {
                System.out.println("LocalAnonymousCounter()");
            }

            @Override
            public int next() {
                System.out.printf("%s", name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {

        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner ");
        Counter c2 = lic.getAnonymousCounter("Anonymous inner ");

        int count = 5;
        for (int i = 0; i < count; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < count; i++) {
            System.out.println(c2.next());
        }
    }
}


interface Counter {
    int next();
}
