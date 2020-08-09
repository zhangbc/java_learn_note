package com.jvm;

/**
 * 引用计数算法的缺陷
 * 问题：testGC()方法执行后，objA和objB会不会被GC呢？
 * VM Args：-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/7/19 18:39
 **/
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 占内存，以便能在GC日志中看清是否回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
