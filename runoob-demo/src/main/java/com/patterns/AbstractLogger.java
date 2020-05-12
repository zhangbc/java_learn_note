package com.patterns;

/**
 * 责任链模式-创建抽象的记录器类(1)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 11:45
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * 写入日志
     * @param message 消息
     */
    protected abstract void write(String message);
}
