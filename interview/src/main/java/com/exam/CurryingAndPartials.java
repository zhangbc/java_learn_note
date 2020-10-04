package com.exam;

import java.util.function.Function;

/**
 * 柯里化应用
 * 
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 11:35
 */
public class CurryingAndPartials {

    /**
     * 未柯里化
     */
    static String incurred(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println(incurred("Hi ", "John"));

        // 柯里化函数
        Function<String, Function<String, String>> sum = a -> b -> a + b;
        Function<String, String> hi = sum.apply("Hi ");
        System.out.println(hi.apply("John"));

        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("John"));
        System.out.println(sumHi.apply("Hey"));
    }
}
