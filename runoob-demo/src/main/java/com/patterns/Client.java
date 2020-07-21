package com.patterns;

/**
 * 业务代表模式--创建客户端(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 00:29
 */
public class Client {

    BusinessDelegate delegate;

    public Client(BusinessDelegate delegate) {
        this.delegate = delegate;
    }

    public void  doTask() {
        delegate.doTask();
    }
}
