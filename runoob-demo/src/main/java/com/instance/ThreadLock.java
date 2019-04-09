package com.instance;

import java.util.Date;

/**
 * Java线程死锁实例
 *
 * java 死锁产生的四个必要条件：
 * 1）互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用。
 * 2）不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。
 * 3）请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有。
 * 4）循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/25 23:51
 */
public class ThreadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        LockA la = new LockA();
        new Thread(la).start();
        LockB lb = new LockB();
        new Thread(lb).start();
    }
}


/**
 * LockA类
 */
class LockA implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA begin running...");
            while (true) {
                synchronized (ThreadLock.obj1) {
                    System.out.println(new Date().toString() + " LockA locking obj1.");
                    // 此处等待是给B能锁住机会
                    Thread.sleep(3000);
                    synchronized (ThreadLock.obj2) {
                        System.out.println(new Date().toString() + " LockA locking obj2.");
                        // 测试，占用不放
                        Thread.sleep(60*1000);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * LockB类
 */
class LockB implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB begin running...");
            while (true) {
                synchronized (ThreadLock.obj2) {
                    System.out.println(new Date().toString() + " LockB locking obj2.");
                    // 此处等待是给B能锁住机会
                    Thread.sleep(3000);
                    synchronized (ThreadLock.obj1) {
                        System.out.println(new Date().toString() + " LockB locking obj1.");
                        // 测试，占用不放
                        Thread.sleep(60*1000);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
