package com.jvm;

/**
 * volatile变量自增运算
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/1 23:12
 */
public class VolatileTest {

    private static volatile int race = 0;
    private static final int THREADS_COUNT = 20;
    private static final int COUNT = 10000;

    private static void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        // 输出：小于200000的随机数
        System.out.println(race);
    }
}
