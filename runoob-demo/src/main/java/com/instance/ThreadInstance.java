package com.instance;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * Java 线程
 * @author zhangbocheng
 * @version 1.0
 * @date 2019/3/16 21:52
 */
public class ThreadInstance {
    public static void main(String[] args) {
        System.out.println("Java 线程！");
    }
}


/**
 * 查看线程是否存活：
 * 通过继承Thread类并使用isAlive()方法来检测一个线程是否存活.
 */
class ThreadAlive extends Thread {
    public static void main(String[] args) {
        ThreadAlive ta = new ThreadAlive();
        ta.setName("Thread");
        System.out.println("Before start(),ta.isAlive()=" + ta.isAlive());

        ta.start();
        System.out.println("Just after start(),ta.isAlive()=" + ta.isAlive());

        int counts = 10;
        for (int i = 0; i < counts; i++) {
            ta.printMsg();
        }
        System.out.println("The end of main(), ta.isAlive()=" + ta.isAlive());
    }

    public void run() {
        int counts = 10;
        for (int i = 0; i < counts; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("thread name: " + name);
    }
}


/**
 * 获取当前线程名称：
 * 通过继承Thread类并使用getName()方法来获取当前线程名称.
 */
class ThreadGetName extends Thread {
    public static void main(String[] args) {
        ThreadGetName ta = new ThreadGetName();
        ta.start();

        int counts = 10;
        for (int i = 0; i < counts; i++) {
            ta.printMsg();
        }
    }

    public void run() {
        int counts = 10;
        for (int i = 0; i < counts; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("thread name: " + name);
    }
}


/**
 * 状态监测：
 * 通过继承Thread类并使用currentThread.getName()方法来监测线程的状态.
 */
class ConditionMonitor extends Thread {
    boolean waiting = true;
    boolean ready = false;

    ConditionMonitor() {}

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting.");
        while (waiting) {
            System.out.println("Waiting: " + waiting);
        }
        System.out.println("waiting...");
        startWait();

        try {
            Thread.sleep(1000);
        } catch (Exception exc) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " terminating.");
    }

    synchronized void startWait() {
        try {
            while (!ready) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("wait() interrupted.");
        }
    }

    synchronized void notice() {
        ready = true;
        notify();
    }
}


/**
 * 状态监测实例
 */
class ConditionMonitorDemo {
    public static void main(String[] args) throws Exception {
        ConditionMonitor cm = new ConditionMonitor();
        cm.setName("ConditionMonitor #1");
        showThreadStatus(cm);

        cm.start();
        Thread.sleep(50);
        showThreadStatus(cm);
        cm.waiting = false;

        Thread.sleep(50);
        showThreadStatus(cm);
        cm.notice();

        Thread.sleep(50);
        showThreadStatus(cm);

        while (cm.isAlive()) {
            System.out.println("Being alive ...");
        }
        showThreadStatus(cm);
    }

    static void showThreadStatus(Thread thread) {
        System.out.printf("%s Alive:=%s, State:=%s", thread.getName(),
                thread.isAlive(), thread.getState());
    }
}


/**
 * 线程优先级设置：
 * 通过setPriority()方法来设置线程的优先级.
 */
class ThreadPriorities extends Thread {
    private int countDown = 5;
    private volatile double num = 0;

    public ThreadPriorities(int priority) {
        setPriority(priority);
        start();
    }

    public String toString() {
        return super.toString() + ": " + countDown;
    }

    public void run() {
        while (true) {
            int counts = 100000;
            for (int i = 0; i < counts; i++) {
                num += (Math.PI + Math.E) / (double)i;
                System.out.println(this);
                if (--countDown == 0){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadPriorities(Thread.MAX_PRIORITY);
        int counts = 5;
        for (int i = 0; i < counts; i++) {
            new ThreadPriorities(Thread.MIN_PRIORITY);
        }
    }
}