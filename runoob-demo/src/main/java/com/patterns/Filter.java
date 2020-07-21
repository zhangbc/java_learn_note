package com.patterns;

/**
 * 拦截过滤器模式--创建过滤器接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:09
 */
public interface Filter {
    /**
     * 执行请求
     * @param request 请求地址
     */
    void execute(String request);
}
