package com.exam;

/**
 * RunnableMethodReference
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 09:54
 */
public class RunnableMethodReference {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("Lambda Expression")
        ).start();

        new Thread(Go::go).start();
    }
}


class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}
