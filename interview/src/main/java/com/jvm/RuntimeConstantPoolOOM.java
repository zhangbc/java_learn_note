package com.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * 运行时常量池导致的内存溢出异常
 * VM Args： -XX:PermSize=6M -XX:MaxPermSize=6M (jdk1.6)
 * VM Args： -Xms6M (> jdk1.6)
 * String::intern()是一个本地方法，作用是如果字符串常量池中已经包含一个等于此String对象的字符串，
 * 则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加到常量池中，
 * 并且返回此String对象的引用。
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/7/19 14:09
 **/
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(16);
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
