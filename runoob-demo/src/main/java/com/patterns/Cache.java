package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务定位器模式--创建缓存Cache(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:35
 */
public class Cache {

    private List<Service> services;

    public Cache() {
        services = new ArrayList<>(16);
    }

    public Service getService(String serviceName) {
        for (Service service: services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached " + serviceName + " object.");
                return service;
            }
        }

        return null;
    }

    public void addService(Service service) {
        boolean exists = false;
        for (Service s: services) {
            if (s.getName().equalsIgnoreCase(service.getName())) {
                exists = true;
            }
        }

        if (!exists) {
            services.add(service);
        }
    }
}
