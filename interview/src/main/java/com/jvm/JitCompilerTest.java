package com.jvm;

/**
 * 查看及分析即时编译结果
 * VM Args： -XX:+PrintCompilation (要求虚拟机在即时编译时将被编译成本地代码的方法名称打印出来)
 * VM Args： -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining (要求虚拟机输出方法内联信息)
 * ==============only in debug version of VM============================
 * VM Args： -XX:+PrintOptoAssembly（用于服务端模式的虚拟机）
 * VM Args： -XX:+PrintLIR（用于客户端模式的虚拟机）来输出比较接近最终结果的中间代码表示
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/21 09:44
 */
public class JitCompilerTest {

    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        // 空循环用于后面演示JIT代码优化过程
        int count = 100000;
        for (int j = 0; j < count; j++) { }
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        int count = 100;
        for (int i = 0; i < count; i++) {
            sum += doubleValue(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
