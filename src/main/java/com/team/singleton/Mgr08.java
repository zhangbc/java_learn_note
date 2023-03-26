package com.team.singleton;

/**
 * 解决线程同步，防止反序列化
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:40 AM
 **/
public enum Mgr08 {
    /**
     * instance
     */
    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        int count = 100;
        // hasCode值是一致的，说明getInstance()是同一个实例
        for (int i = 0; i < count; i++) {
            new Thread(() ->
                    System.out.println(Mgr08.INSTANCE.hashCode())
            ).start();
        }
    }
}
