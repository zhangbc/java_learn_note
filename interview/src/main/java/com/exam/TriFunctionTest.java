package com.exam;

/**
 * 多参数函数式接口
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 10:10
 */
public class TriFunctionTest {

    static double f(int i, long l, double d) {
        return i + l + d;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Double> tf = TriFunctionTest::f;
        System.out.println(tf.apply(2, 2L, 3.0d));

        tf = (i, l, d) -> i * l * d;
        System.out.println(tf.apply(2, 2L, 3.0d));
    }
}


@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
