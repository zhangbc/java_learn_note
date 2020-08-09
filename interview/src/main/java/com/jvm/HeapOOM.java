package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出异常测试
 * VM Args： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author zhangbc
 * @version 1.0.0
 * @date 2020/7/12 17:25
 **/
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> objectList = new ArrayList<>();
        while (true) {
            objectList.add(new OOMObject());
        }
    }
}
