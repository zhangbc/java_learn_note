package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/8 15:40
 */
public class TestTryCatch {

    public static void main(String[] args) {

        System.out.println(getNumber(0));
        System.out.println(getNumber(1));
        System.out.println(getNumber(2));
        System.out.println(getNumber(3));
        System.out.println(getNumber(4));
    }

    private static int getNumber(int num) {
        try {
            int result = 2 / num;
            return result;
        } catch (Exception e) {
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            }

            if (num == 1) {
                return 1;
            }
        }
    }
}
