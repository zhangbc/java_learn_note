package com.exam;

import java.util.function.Function;

/**
 * 函数组合
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 11:23
 */
public class FunctionComposition {

    static Function<String, String> f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
    f2 = s -> s.substring(3),
    f3 = String::toLowerCase,
    f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {

        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }
}
