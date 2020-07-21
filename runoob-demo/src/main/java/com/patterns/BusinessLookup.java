package com.patterns;

/**
 * 业务代表模式--创建业务查询服务(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 12:08
 */
public class BusinessLookup {
    public BusinessService getBusinessService(String serviceType) {
        String ejb = "EJB";
        if (serviceType.equals(ejb)) {
            return new EjbService();
        } else {
            return new JmsService();
        }
    }
}
