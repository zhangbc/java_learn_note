package com.jvm;

/**
 * 局部变量表槽复用对垃圾收集的影响之一
 * VM Args：-verbose:gc
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/20 23:41
 */
public class LocalTableOne {
    public static void main(String[] args) {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
