package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/23 23:51
 */
public class Sub extends Super {

    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }


    public static void main(String[] args) {
        Super sup = new Sub();
        // 输出： 0 1
        System.out.println(sup.field + " " + sup.getField());

        Sub sub = new Sub();
        // 输出： 1 1 0
        System.out.println(sub.field + " " + sub.getField() + " " + sub.getSuperField());
    }
}


class Super {

    public int field = 0;

    public int getField() {
        return field;
    }
}
