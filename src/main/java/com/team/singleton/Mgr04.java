package com.team.singleton;

/**
 * 懒汉式（lazy loading）
 * 虽然达到了按需初始化的目的，但是引入了线程不安全的问题
 * 解决方案：通过synchronized解决，但是效率下降
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:40 AM
 **/
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {}

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new Mgr04();
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
                    System.out.println(Mgr04.getInstance().hashCode())
            ).start();
        }
    }
}
