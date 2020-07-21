package com.patterns;

/**
 * 服务定位器模式--使用ServiceLocator来演示服务定位器模式(6)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:48
 */
public class PatternDemoServiceLocator {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("ServiceOne");
        service.execute();

        service = ServiceLocator.getService("ServiceTwo");
        service.execute();

        service = ServiceLocator.getService("ServiceOne");
        service.execute();

        service = ServiceLocator.getService("ServiceTwo");
        service.execute();
    }
}
