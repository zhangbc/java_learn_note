package com.instance;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 死锁解决办法
 * 解决死锁问题的方法：1)用synchronized; 2)用Lock显式锁实现。
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/26 00:09
 */
public class ThreadUnlock {
    public static final Semaphore obj_a = new Semaphore(1);
    public static final Semaphore obj_b = new Semaphore(1);

    public static void main(String[] args) {
        UnlockA la = new UnlockA();
        new Thread(la).start();
        UnlockB lb = new UnlockB();
        new Thread(lb).start();
    }
}


/**
 * UnlockA类
 */
class UnlockA implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " UnlockA begin running...");
            while (true) {
                if (ThreadUnlock.obj_a.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " UnlockA locking obj1.");
                    if (ThreadUnlock.obj_b.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " UnlockA locking obj2.");
                        // 测试，占用不放
                        Thread.sleep(60*1000);
                    } else {
                        System.out.println(new Date().toString() + " UnlockA locking obj2 failed.");
                    }
                } else {
                    System.out.println(new Date().toString() + " UnlockA locking obj1 failed.");
                }

                ThreadUnlock.obj_a.release();
                ThreadUnlock.obj_b.release();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * UnlockB类
 */
class UnlockB implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " UnlockB begin running...");
            while (true) {
                if (ThreadUnlock.obj_b.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " UnlockB locking obj2.");
                    if (ThreadUnlock.obj_a.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " UnlockB locking obj1.");
                        // 测试，占用不放
                        Thread.sleep(60*1000);
                    } else {
                        System.out.println(new Date().toString() + " UnlockB locking obj1 failed.");
                    }
                } else {
                    System.out.println(new Date().toString() + " UnlockB locking obj2 failed.");
                }

                ThreadUnlock.obj_a.release();
                ThreadUnlock.obj_b.release();
                Thread.sleep(10*1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
