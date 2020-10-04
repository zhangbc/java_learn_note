package com.exam;

import java.util.function.Function;

/**
 * 高阶函数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/26 10:58
 */
public class TransformFunction {

    static Function<Input, Output> transform(Function<Input, Output> in) {
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<Input, Output> f = transform(i -> {
            System.out.println(i);
            return new Output();
        });

       f.apply(new Input());
    }
}


class Input {
    @Override
    public String toString() {
        return "Input";
    }
}


class Output {
    @Override
    public String toString() {
        return "Output";
    }
}
