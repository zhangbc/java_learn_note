package com.team.singleton;

/**
 * 双重锁机制
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:40 AM
 **/
public class Mgr06 {
    private static Mgr06 INSTANCE;

    private Mgr06() {}

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            // 双重检查
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Mgr06();
                }
            }
        }

        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        int count = 100;
        // hasCode值是一致的，说明getInstance()是同一个实例
        for (int i = 0; i < count; i++) {
            new Thread(() ->
                    System.out.println(Mgr06.getInstance().hashCode())
            ).start();
        }
    }
}
