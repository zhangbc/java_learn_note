package com.exam;

import java.util.Scanner;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/10 19:40
 */
public class Solution202104102 {
    public static void main(String[] args) {
        Solution202104102 cls = new Solution202104102();

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            String[] array = sc.nextLine().split(" ");
            sb.append(cls.getActiveRate(Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                    Double.parseDouble(array[2])));
            sb.append("\n");
            count--;
        }

        System.out.println(sb.toString());
    }

    private double getActiveRate(int a, int b, double rate) {
        double total = 0.0;
        for (int i = b; i <= a; i++) {
            total += compute(a, i, rate);
        }
        return total;
    }

    private double compute(int a, int i, double rate) {
        long p = getNumber(a) / (getNumber(a - i) * getNumber(i));
        return  p * Math.pow(rate, i) * Math.pow(1 - rate, a - i);
    }

    private long getNumber(int a) {
        long p = 1;
        while (a > 1) {
            p *= a;
            a--;
        }

        return p;
    }
}
