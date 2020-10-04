package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 16:20
 */
public class ThreadsDemo {

    public static void main(String[] args) {
        new ThreadsDemo().go();
    }

    private void go() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

}
