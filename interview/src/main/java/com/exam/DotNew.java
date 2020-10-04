package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 15:46
 */
public class DotNew {
    public class Inner {
        public DotNew outer() {
            return DotNew.this;
        }
    }
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();

        int x, y;
        x = 5 << 2;
        y = x >>> 2;
        System.out.println(x + " " + y);
    }
}