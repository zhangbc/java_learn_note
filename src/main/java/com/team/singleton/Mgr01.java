package com.team.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 优点：简单实用，推荐使用
 * 缺点：不管用到与否，类装载时就完成实例化
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:02 AM
 **/
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {}

    public static Mgr01 getInstance() {
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
                    System.out.println(Mgr07.getInstance().hashCode())
            ).start();
        }
    }
}
