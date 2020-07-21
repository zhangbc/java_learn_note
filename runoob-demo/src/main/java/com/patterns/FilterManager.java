package com.patterns;

/**
 * 拦截过滤器模式--创建过滤管理器(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:21
 */
public class FilterManager {

    FilterChain chain;

    public FilterManager(Target target) {
        chain = new FilterChain();
        chain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        chain.addFilter(filter);
    }

    public void filterRequest(String request) {
        chain.execute(request);
    }
}
