package com.patterns;

/**
 * 组合实体模式--使用Client来演示组合实体模式(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 01:12
 */
public class PatternDemoCompositeEntity {
    public static void main(String[] args) {
        CompositeClient client = new CompositeClient();
        client.setData("Test", "Data1");
        client.printData();

        client.setData("Second Test", "Data2");
        client.printData();
    }
}
