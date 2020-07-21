package com.patterns;

/**
 * 服务定位器模式--创建服务定位器(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:43
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
