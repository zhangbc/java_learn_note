package com.jvm;

/**
 * 一次对象自我拯救的演示：
 *                     1）对象可以在被GC时自我拯救；
 *                     2）这种自救的机会只有一次， 因为一个对象的finalize()方法最多只会被系统自动调用一次
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/8/8 15:22
 **/
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC saveHook = null;

    public void isAlive() {
        System.out.println("Yes, I am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed.");
        FinalizeEscapeGC.saveHook = this;
    }

    public static void main(String[] args) throws Throwable {

        saveHook = new FinalizeEscapeGC();
        saveHook = null;
        System.gc();
        // 因为Finalizer方法的优先级很低，暂停0.5s等待。
        Thread.sleep(500);

        if (saveHook != null) {
            saveHook.isAlive();
        } else {
            System.out.println("No, I am dead(first).");
        }

        saveHook = null;
        System.gc();
        // 因为Finalizer方法的优先级很低，暂停0.5s等待。
        Thread.sleep(500);

        if (saveHook != null) {
            saveHook.isAlive();
        } else {
            System.out.println("No, I am dead(second).");
        }
    }
}
