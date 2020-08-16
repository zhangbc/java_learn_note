package com.jvm;

/**
 * 死循环(初始化)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/18 00:26
 */
public class DeadLoop {

    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoop Class.");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start.");
                new DeadLoop();
                System.out.println(Thread.currentThread() + " end.");
            }
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
