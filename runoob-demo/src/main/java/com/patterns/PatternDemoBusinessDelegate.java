package com.patterns;

/**
 * 业务代表模式--使用BusinessDelegate和Client类来演示业务代表模式(5)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/20 00:31
 */
public class PatternDemoBusinessDelegate {

    public static void main(String[] args) {
        BusinessDelegate delegate = new BusinessDelegate();
        delegate.setServiceType("EJB");

        Client client = new Client(delegate);
        client.doTask();

        delegate.setServiceType("JMS");
        client.doTask();
    }
}
