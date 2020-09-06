package com.jvm;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * 方法调用问题
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/3 10:52
 */
public class GrandFatherTest {
    public static void main(String[] args) {
        (new SonMethodHandle()).thinking();
        (new SonMethodHandleTrust()).thinking();
    }
}


class GrandFather {
    void thinking() {
        System.out.println("I am grandfather.");
    }
}


class Father extends GrandFather {
    @Override
    void thinking() {
        System.out.println("I am father.");
    }
}


/**
 * 问题：实现调用祖父类的thinking()方法，打印 "I am grandfather."
 *
 * 使用JDK 7 Update 9之前的HotSpot虚拟机运行，结果为：I am grandfather.
 * 使用JDK 7 Update 10修正之后的HotSpot虚拟机运行，结果为：I am father.
 *
 */
class SonMethodHandle extends Father {
    @Override
    void thinking() {
        try {
            MethodType mt = MethodType.methodType(void.class);
            MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
            mh.invoke(this);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}


/**
 * 问题：实现调用祖父类的thinking()方法，打印 "I am grandfather."
 *
 */
class SonMethodHandleTrust extends Father {
    @Override
    void thinking() {
        try {
            MethodType mt = MethodType.methodType(void.class);
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class,
                    "thinking", mt, GrandFather.class);
            mh.invoke(this);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
