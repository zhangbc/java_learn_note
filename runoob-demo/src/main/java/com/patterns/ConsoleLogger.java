package com.patterns;

/**
 * 责任链模式-创建实现抽象记录器类的ConsoleLogger实体类(2)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 11:52
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
