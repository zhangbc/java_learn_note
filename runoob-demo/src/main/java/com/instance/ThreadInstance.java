package com.instance;

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

    @Override
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
class ThreadPrioritiesSet extends Thread {
    private int countDown = 5;
    private volatile double num = 0;

    public ThreadPrioritiesSet(int priority) {
        setPriority(priority);
        start();
    }

    @Override
    public String toString() {
        return super.toString() + ": " + countDown;
    }

    @Override
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
        new ThreadPrioritiesSet(Thread.MAX_PRIORITY);
        int counts = 5;
        for (int i = 0; i < counts; i++) {
            new ThreadPrioritiesSet(Thread.MIN_PRIORITY);
        }
    }
}


/**
 * 获取线程id：
 * 使用 getThreadId() 方法获取线程id.
 */
class ThreadGetID extends Object implements Runnable {
    private ThreadID tid;

    public ThreadGetID(ThreadID tid) {
        this.tid = tid;
    }

    @Override
    public void run() {
        try {
            print("tid getThreadID = " + tid.getThreadID());
            Thread.sleep(2000);
            print("tid getThreadID = " + tid.getThreadID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

    public static void main(String[] args) {
        ThreadID tid = new ThreadID();
        ThreadGetID threadGetID = new ThreadGetID(tid);

        try {
            Thread ta = new Thread(threadGetID, "ThreadA");
            ta.start();
            Thread.sleep(500);

            Thread tb = new Thread(threadGetID, "ThreadB");
            tb.start();
            Thread.sleep(500);

            Thread tc = new Thread(threadGetID, "ThreadC");
            tc.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * ThreadID类
 */
class ThreadID extends ThreadLocal {
    private int nextID;

    public ThreadID() {
        nextID = 10001;
    }

    private synchronized Integer getNewID() {
        Integer id = new Integer(nextID);
        nextID++;
        return id;
    }

    @Override
    protected Object initialValue() {
        print("in initialValue()");
        return getNewID();
    }

    public int getThreadID() {
        Integer id = (Integer) get();
        return id.intValue();
    }

    public static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }
}


/**
 * 线程挂起
 */
class ThreadSleep extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public ThreadSleep() {
        super(" " + ++threadCount);
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)
    throws InterruptedException {
        int counts = 5;
        for (int i = 0; i < counts; i++) {
            new ThreadSleep().join();
        }
        System.out.println("线程已被挂起！！！");
    }
}


/**
 * 终止线程：
 * （1）线程处于阻塞状态，如使用了sleep方法；
 * （2）使用while（！isInterrupted（））{……}来判断线程是否被中断。
 */
class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new ThreadInterrupt();
        thread.start();
        System.out.println("在50s内按任意键中断线程！");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出！");
    }
}


/**
 * 生产者和消费者实例
 */
class ProducerConsumer {
    public static void main(String[] args) {
        CubbyHole cubbyHole = new CubbyHole();
        Producer p = new Producer(cubbyHole, 1);
        Consumer c = new Consumer(cubbyHole, 1);
        p.start();
        c.start();
    }
}


/**
 * CubbyHole类
 */
class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}


/**
 * Consumer类
 */
class Consumer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Consumer(CubbyHole c, int n) {
        cubbyHole = c;
        this.number = n;
    }

    @Override
    public void run() {
        int value;
        int counts = 10;
        for (int i = 0; i < counts; i++) {
            value = cubbyHole.get();
            System.out.println("消费者 #" + this.number + " got: " + value);
        }
    }
}


/**
 * Producer类
 */
class Producer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Producer(CubbyHole c, int n) {
        cubbyHole = c;
        this.number = n;
    }

    @Override
    public void run() {
        int counts = 10;
        for (int i = 0; i < counts; i++) {
            cubbyHole.put(i);
            System.out.println("生产者 #" + this.number + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * ThreadStatus类：
 * Java中的线程的生命周期大体可分为5种状态：
 * 1. 新建状态（New）：新创建了一个线程对象；
 * 2. 就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。
 *                       该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权；
 * 3. 运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码；
 * 4. 阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。
 *                      直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
 *                      （一）等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中；
 *                      （二）同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，
 *                                   则JVM会把该线程放入锁池中；
 *                      （三）其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，
 *                                   JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、
 *                                   或者I/O处理完毕时，线程重新转入就绪状态；
 * 5. 死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
 */
class ThreadStatus extends Thread {
    boolean waiting = true;
    boolean ready = false;

    ThreadStatus() {}

    @Override
    public void run() {
        String thrdName = Thread.currentThread().getName();
        System.out.println(thrdName + " 启动.");

        while (waiting) {
            System.out.println("等待： " + waiting);
        }
        System.out.println("等待...");
        startWait();
        try {
            Thread.sleep(1000);
        } catch (Exception exc) {
            System.out.println(thrdName + " 中断。");
        }
        System.out.println(thrdName + " 结束。");
    }

    synchronized void startWait() {
        try {
            while (!ready) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("wait()中断。");
        }
    }

    synchronized void notice() {
        ready = true;
        notify();
    }
}


/**
 * 获取线程状态
 */
class ThreadStatusDemo {
    public static void main(String[] args) throws Exception {
        ThreadStatus threadStatus = new ThreadStatus();
        threadStatus.setName("ThreadStatus #1");
        showThreadStatus(threadStatus);

        threadStatus.start();
        Thread.sleep(50);
        showThreadStatus(threadStatus);

        threadStatus.waiting = false;
        Thread.sleep(50);
        showThreadStatus(threadStatus);

        threadStatus.notice();
        Thread.sleep(50);
        showThreadStatus(threadStatus);

        while (threadStatus.isAlive()) {
            System.out.println("Thread is alive.");
        }
        showThreadStatus(threadStatus);
    }

    static void showThreadStatus (Thread thread) {
        System.out.println(thread.getName() + " 存活：" + thread.isAlive()
                + " 状态：" + thread.getState());
    }
}


/**
 * 获取所有线程：
 * 使用getName()方法获取所有正在运行的线程.
 */
class ThreadAll extends Thread {
    public static void main(String[] args) {
        ThreadAll ta = new ThreadAll();
        ta.setName("thread_name");
        ta.start();

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] listThreads = new Thread[noThreads];
        currentGroup.enumerate(listThreads);

        for (int i = 0; i < noThreads; i++) {
            System.out.println("线程号：" + i + " = " + listThreads[i].getName());
        }
    }
}


/**
 * 查看线程优先级：
 * 使用getThreadId()方法获取线程id.
 */
class ThreadPriorities extends Object {
    public static void main(String[] args) {
        System.out.println("In main()-Thread.currentThread().getPriority()="
                + Thread.currentThread().getPriority());
        System.out.println("In main()-Thread.currentThread().getName()="
                + Thread.currentThread().getName());

        Thread threadA = new Thread(makeRunnable(), "treadA");
        threadA.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        System.out.println("In main()-threadA.getPriority()="
                + threadA.getPriority());
    }

    private static Runnable makeRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int counts = 5;
                for (int i = 0; i < counts; i++) {
                    Thread t = Thread.currentThread();
                    System.out.println("In run() - priority=" + t.getPriority()
                            + ", name=" + t.getName());
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        };
        return runnable;
    }
}


class ThreadStop extends Object implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("In run() - 将运行work2()方法.");
            work2();
            System.out.println("In run() - 从work2()方法回来.");
        } catch (InterruptedException exc) {
            System.out.println("In run() - 中断work2()方法.");
            return;
        }
        System.out.println("In run() - 休眠后执行.");
        System.out.println("In run() - 正常离开.");
    }

    public void work2() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("C isInterrupted() = " + Thread.currentThread().isInterrupted());
                Thread.sleep(2000);
                System.out.println("D isInterrupted() = " + Thread.currentThread().isInterrupted());
            }
        }
    }

    public void work() throws InterruptedException {
        while (true) {
            int counts = 100000;
            for (int i = 0; i < counts; i++) {
                int j = i * 2;
            }

            System.out.println("A isInterrupted() = " + Thread.currentThread().isInterrupted());
            if (Thread.interrupted()) {
                System.out.println("B isInterrupted() = " + Thread.currentThread().isInterrupted());
                throw new InterruptedException();
            }
        }
    }

    public static void main(String[] args) {
        ThreadStop st = new ThreadStop();
        Thread thread = new Thread(st);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        System.out.println("In main() - 中断其他线程.");
        thread.interrupt();
        System.out.println("In main() - 离开.");
    }
}