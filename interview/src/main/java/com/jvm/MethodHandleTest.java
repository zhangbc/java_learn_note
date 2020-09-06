package com.jvm;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * 方法句柄
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 20:08
 */
public class MethodHandleTest {

    static class Demo {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new Demo();
        getPrintln(obj).invokeExact("com.jvm");
    }

    private static MethodHandle getPrintln(Object receiver) throws Throwable {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）
        // 和具体参数（methodType()第二个及以后的参数）。
        MethodType type = MethodType.methodType(void.class, String.class);
        // lookup()方法来自于MethodHandles.lookup，
        // 这句的作用是在指定类中查找符合给定的方法 名称、方法类型，并且符合调用权限的方法句柄。
        return lookup().findVirtual(receiver.getClass(), "println", type).bindTo(receiver);
    }
}
