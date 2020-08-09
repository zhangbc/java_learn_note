package com.jvm;

/**
 * 虚拟机栈和本地方法栈测试(使用 `-Xss` 参数减少栈内存容量)
 * VM Args： -Xss128k
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/7/12 17:47
 **/
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF stackSOF = new JavaVMStackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length: " + stackSOF.stackLength);
            throw e;
        }
    }
}
