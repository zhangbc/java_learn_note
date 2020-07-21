package com.patterns;

/**
 * 拦截过滤器模式--创建Target(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:11
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
