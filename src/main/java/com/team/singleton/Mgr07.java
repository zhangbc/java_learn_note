package com.team.singleton;

/**
 * 静态内部类方式
 * JVM 保证单例：加载外部类时不会加载外部类，即可实现懒加载
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:40 AM
 **/
public class Mgr07 {

    private Mgr07() {}

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
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
