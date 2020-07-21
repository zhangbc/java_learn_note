package com.patterns;

/**
 * 业务代表模式--创建业务代表(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 12:13
 */
public class BusinessDelegate {

    private BusinessLookup lookup = new BusinessLookup();
    private BusinessService service;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        service = lookup.getBusinessService(serviceType);
        service.doProcessing();
    }
}
