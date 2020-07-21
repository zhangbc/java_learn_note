package com.patterns;

/**
 * 服务定位器模式--为JNDI查询创建InitialContext(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:28
 */
public class InitialContext {
    public Object lookup(String jndiName) {
        String[] strings = {"ServiceOne", "ServiceTwo"};
        if (jndiName.equalsIgnoreCase(strings[0])) {
            System.out.println("Looking up and creating a new ServiceOne object.");
            return new ServiceOne();
        }

        if (jndiName.equalsIgnoreCase(strings[1])) {
            System.out.println("Looking up and creating a new ServiceTwo object.");
            return new ServiceTwo();
        }

        return null;
    }
}
