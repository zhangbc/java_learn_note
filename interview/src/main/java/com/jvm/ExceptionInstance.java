package com.jvm;

/**
 * 异常表运作实例
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/16 13:30
 */
public class ExceptionInstance {

    private static int getNumber() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber());
    }
}

