package com.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic 变量自增运算测试
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/31 17:30
 */
public class AtomicTest {

    private static final int THREADS_COUNT = 20;
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 10000;
                    for (int j = 0; j < count; j++) {
                        increase();
                    }
                }
            });

            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        // 输出：200000
        System.out.println(race);
    }
}
