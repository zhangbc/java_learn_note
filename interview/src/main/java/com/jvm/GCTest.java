package com.jvm;

/**
 * 垃圾收集器日志测试
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/8/9 19:00
 **/
public class GCTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] alloc1, alloc2, alloc3, alloc4;
        alloc1 = new byte[2 * _1MB];
        alloc2 = new byte[2 * _1MB];
        alloc3 = new byte[2 * _1MB];
        alloc4 = new byte[4 * _1MB];
    }
}
