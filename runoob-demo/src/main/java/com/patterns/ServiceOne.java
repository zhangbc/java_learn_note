package com.patterns;

/**
 * 服务定位器模式--创建实体服务(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:24
 */
public class ServiceOne implements Service {

    @Override
    public String getName() {
        return "ServiceOne";
    }

    @Override
    public void execute() {
        System.out.println("Executing ServiceOne");
    }
}
