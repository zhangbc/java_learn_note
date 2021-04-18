package com.exam;

import java.util.Scanner;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/10 19:40
 */
public class Solution20210410 {
    public static void main(String[] args) {
        Solution20210410 cls = new Solution20210410();

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            String[] array = sc.nextLine().split(" ");
            sb.append(cls.getCounts(Long.parseLong(array[0]), Long.parseLong(array[1])));
            sb.append("\n");
            count--;
        }

        System.out.println(sb.toString());
    }

    private long getCounts(long a, long b) {
        if (a < 1 || b < 1) {
            return 0;
        }

        if (a == 1 || b == 1) {
            return a > b ? a - b : b - a;
        }

        long count = 0;
        while (a > 1 && b > 1) {
            if (a > b) {
                a = a / b;
            } else {
                b = b / a;
            }
            count++;
        }

        return count + Math.abs(a - b);
    }
}
