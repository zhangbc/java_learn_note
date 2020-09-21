package com.jvm;

/**
 * 包含了多处不规范命名的代码样例
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/20 18:23
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }
}
