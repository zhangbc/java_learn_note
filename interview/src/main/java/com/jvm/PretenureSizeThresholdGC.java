package com.jvm;

/**
 * 大对象直接进入老年代 GC
 * VM Args： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/10 00:45
 */
public class PretenureSizeThresholdGC {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        // 直接分配在老年代中
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
