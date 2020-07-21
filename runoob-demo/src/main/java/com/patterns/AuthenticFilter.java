package com.patterns;

/**
 * 拦截过滤器模式--创建过滤器实体(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 01:11
 */
public class AuthenticFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
