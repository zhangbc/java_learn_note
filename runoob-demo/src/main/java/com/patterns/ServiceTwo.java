package com.patterns;

/**
 * 服务定位器模式--创建实体服务(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:24
 */
public class ServiceTwo implements Service {

    @Override
    public String getName() {
        return "ServiceTwo";
    }

    @Override
    public void execute() {
        System.out.println("Executing ServiceTwo");
    }
}
