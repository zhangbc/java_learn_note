package com.jvm;


import java.util.Vector;

/**
 * 必须加入同步保证Vector访问的线程安全性
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/29 00:54
 */
public class VectorThreadSynchronizedTest {
    private static Vector<Integer> vector = new Vector<>(16);

    public static void main(String[] args) {
        while (true) {
            int count = 100;
            for (int i = 0; i < count; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();

            int number = 20;
            while (Thread.activeCount() > number) { }
        }
    }
}
