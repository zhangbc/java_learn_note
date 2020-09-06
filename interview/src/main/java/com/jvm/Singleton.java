package com.jvm;

/**
 * DCL单例模式
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/2 11:02
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {
        System.out.println(Thread.currentThread().getName() + " ===== Singleton.Singleton =======");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i <= count; i++) {
            new Thread(() -> {
                Singleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
