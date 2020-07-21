package com.patterns;

/**
 * 业务代表模式--创建实体服务类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/19 12:01
 */
public class EjbService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
