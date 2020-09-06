package org.jvm;

import java.lang.reflect.Method;

/**
 * Java Class 执行工具
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/4 17:06
 */
public class JavaClassExecutor {

    public static String execute(byte[] bytes) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(bytes);
        byte[] modiBytes = cm.modifyUtf8Constant("java/lang/System", "org/jvm/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class cls = loader.loadByte(modiBytes);
        try {
            Method method = cls.getMethod("main", new Class[] {String[].class});
            method.invoke(null, new String[] {null});
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return HackSystem.getBufferString();
    }
}
