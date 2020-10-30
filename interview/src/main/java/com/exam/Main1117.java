package com.exam;

import java.util.Scanner;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/17 19:08
 */
public class Main1117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = getSameCode(str);
        System.out.println(count);
    }

    private static int getSameCode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) - 'A');
        }

        int count = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
            int tmp = Integer.parseInt(sb.substring(i, i + 2));
            if (tmp > 9 && tmp < 26) {
                count++;
            }
        }
        return count;
    }
}
