package com.team.singleton;

/**
 * 同 Mgr01
 *
 * @author zhangbc
 * @version v1.0.0
 * @date 9/13/22 12:16 AM
 **/
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {}

    public static Mgr02 getInstance() {
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
