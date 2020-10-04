package com.exam;

/**
 * java 标签机制
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/18 18:17
 */
public class LabeledFor {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {

        int i = 0;
        outer:
        for (; true;) {
            System.out.println("outer loop");
            inner:
            for (; i < 10; i++) {
                System.out.println("inner loop");
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }

                if (i == 3) {
                    System.out.println("break");
                    i++;
                }

                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }

                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }

                for (int j = 0; j < 5; j++) {
                    if (i == 3) {
                        System.out.println("continue outer");
                        continue outer;
                    }
                }
            }
        }
    }
}
