package com.patterns;

/**
 * 迭代器模式-使用NameRepository来获取迭代器，并打印名字(3)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/5/12 13:08
 */
public class PatternDemoIterator {
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();

        for (Iterator iterator = repository.getIterator(); iterator.hasNext(); ) {
            System.out.println("Name: " + iterator.next());
        }
    }
}
