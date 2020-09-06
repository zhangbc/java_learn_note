package com.jvm;

import java.util.Vector;

/**
 * 对 Vector 线程安全的测试
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/29 00:54
 */
public class VectorThreadTest {
    private static Vector<Integer> vector = new Vector<>(16);

    public static void main(String[] args) {
        while (true) {
            int count = 10;
            for (int i = 0; i < count; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
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
