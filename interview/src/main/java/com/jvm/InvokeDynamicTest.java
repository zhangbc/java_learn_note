package com.jvm;

import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * InvokeDynamic指令
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/8/22 20:08
 */
public class InvokeDynamicTest {

    public static void main(String[] args) throws Throwable {
        IndyBootstrapMethod().invokeExact("com.jvm.InvokeDynamicTest");
    }

    private static MethodHandle IndyBootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MhBootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }

    private static MethodHandle MhBootstrapMethod() throws Throwable {
        return lookup().findStatic(InvokeDynamicTest.class, "BoostrapMethod", MtBoostrapMethod());
    }

    private static MethodType MtBoostrapMethod() {
        return MethodType
                .fromMethodDescriptorString(
                        "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;) Ljava/lang/invoke/CallSite;", null);
    }

    public static CallSite BoostrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt)
        throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    public static void testMethod(String s) {
        System.out.println("Hello String: " + s);
    }
}
