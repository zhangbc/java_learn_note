package com.patterns;

/**
 * 拦截过滤器模式--创建客户端(6)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:25
 */
public class FilterClient {

    FilterManager manager;

    public void setFilterManager(FilterManager manager) {
        this.manager = manager;
    }

    public void sendRequest(String request) {
        manager.filterRequest(request);
    }
}
