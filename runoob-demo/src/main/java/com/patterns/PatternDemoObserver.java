package com.patterns;

import org.apache.commons.codec.binary.Hex;

/**
 * 观察者模式-使用Subject和实体观察者对象(4)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/13 12:37
 */
public class PatternDemoObserver {
    public static void main(String[] args) {

        Subject subject = new Subject();
        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
