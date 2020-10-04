package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/11 22:16
 */
public class Test {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public void exchange(String str, char[] ch) {
        str = "test ok.";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        StaticsClass staticsClass = StaticsClass.getInstance();
        System.out.println(StaticsClass.c1);
        System.out.println(StaticsClass.c2);
        System.out.println(StaticsClass.c3);

        StaticDemo demo = new StaticDemo();
        System.out.println(demo.i);
        StaticDemo demo1 = new StaticDemo();
        StaticDemo.i++;
        System.out.println(demo1.i);
        Byte a = 127;
        System.out.println(++a);

        Test test = new Test();
        test.exchange(test.str, test.ch);
        System.out.println(test.str + " and " + test.ch.toString());
    }
}


class StaticsClass {
    static int c1 = 0;
    private static StaticsClass staticsClass = new StaticsClass();
    static int c2 = 1;
    static int c3 = 3;

    static {
        c3++;
    }

    private StaticsClass() {
        c1++;
        c2++;
        ++c3;
    }

    static StaticsClass getInstance() {
        return staticsClass;
    }
}


class StaticDemo {
    static int i = 1;
}