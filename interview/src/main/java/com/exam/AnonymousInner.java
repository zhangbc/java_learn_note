package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 16:38
 */
public class AnonymousInner {

    public Contents contents() {
        return new Contents() {

            private int i = 11;

            @Override
            public int value() {
                System.out.println("AnonymousInner.Contents i=" + i);
                return i;
            }
        };
    }

    public static void main(String[] args) {
        AnonymousInner inner = new AnonymousInner();
        Contents contents = inner.contents();
        contents.value();
    }
}


interface Contents {
    int value();
}