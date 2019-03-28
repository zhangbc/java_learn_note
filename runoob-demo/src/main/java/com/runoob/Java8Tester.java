package com.runoob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * JAVA8 编程风格
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/28 20:43
 */
public class Java8Tester {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用 Java7 语法：");
        tester.sortUsingJava7(names1);
        System.out.println(names1);

        System.out.println("使用 Java8 语法：");
        tester.sortUsingJava8(names2);
        System.out.println(names2);
    }

    /**
     * 使用Java7排序
     * @param names
     */
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * 使用Java8排序
     * @param names
     */
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }
}
