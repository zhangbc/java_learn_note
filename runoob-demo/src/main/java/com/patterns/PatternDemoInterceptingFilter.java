package com.patterns;

/**
 * 拦截过滤器模式--使用Client来演示拦截过滤器模式(7)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:29
 */
public class PatternDemoInterceptingFilter {
    public static void main(String[] args) {
        FilterManager manager = new FilterManager(new Target());
        manager.setFilter(new AuthenticFilter());
        manager.setFilter(new DebugFilter());

        FilterClient client = new FilterClient();
        client.setFilterManager(manager);
        client.sendRequest("HOME");
    }
}
