package com.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型&装箱示例
 * 1. 裸类型赋值
 * 2. 自动装箱、拆箱与遍历循环
 * 3. 自动装箱的陷阱
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/17 23:44
 */
public class GenericsDemo {

    public static void main(String[] args) {

        /**
         * 1. 裸类型赋值
         */
        ArrayList<Integer> iList = new ArrayList<>(16);
        ArrayList<String> sList = new ArrayList<>(16);
        // 裸类型
        ArrayList list;
        list = iList;
        list = sList;

        /**
         * 2. 自动装箱、拆箱与遍历循环
         */
        List<Integer> ls = Arrays.asList(1, 2, 3, 4);
        int sum =0;
        for (int i: ls) {
            sum += i;
        }

        System.out.println(sum);

        /**
         *  3. 自动装箱的陷阱
         */
        Integer a = 1, b = 2, c = 3, d = 3;
        Integer e = 321, f = 321;
        Long g = 3L;
        // true
        System.out.println(c == d);
        // false
        System.out.println(e == f);
        // true
        System.out.println(c == (a + b));
        // true
        System.out.println(c.equals(a + b));
        // true
        System.out.println(g == (a + b));
        // false
        System.out.println(g.equals(a + b));
    }
}
