package com.team.singleton;

/**
 * 懒汉式（lazy loading）
 * 虽然达到了按需初始化的目的，但是引入了线程不安全的问题
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:23 AM
 **/
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {}

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new Mgr03();
        }

        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        int count = 100;
        // hasCode值并不是一致的，说明getInstance()并不是同一个实例
        for (int i = 0; i < count; i++) {
            new Thread(() ->
                System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
