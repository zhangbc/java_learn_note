package com.patterns;

/**
 * 服务定位器模式--创建接口(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/7/21 23:22
 */
public interface Service {

    /**
     * 获取名称
     * @return 返回名称
     */
    String getName();

    /**
     * 执行命令
     */
    void execute();
}
