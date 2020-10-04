package com.exam;

import java.util.Iterator;

/**
 * 迭代器实现
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 21:49
 */
public class IterableClass implements Iterable<String> {

    protected String[] words = "And that is how we know the Earth to the banana-shaped.".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s: new IterableClass()) {
            System.out.printf("%s ", s);
        }
    }
}
