package com.patterns;

/**
 * 责任链模式-实现不同类型的记录器(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 11:56
 */
public class PatternDemoChain {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLoggers();
        logger.logMessage(AbstractLogger.INFO, "This is an information.");
        logger.logMessage(AbstractLogger.DEBUG, "This is a debug information.");
        logger.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
