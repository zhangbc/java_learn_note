package com.exam;

/**
 * RecursiveFibonacci
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 09:41
 */
public class RecursiveFibonacci {

    IntCall fib;

    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();

        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(fibonacci.fibonacci(i));
        }
    }
}


interface IntCall {
    int call(int arg);
}