package com.exam;

import java.util.Scanner;

/**
 * 字符串比较 (25%)
 *
 * 示例：xxcdefg
 *      cdefghi
 *      5
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/18 16:07
 */
public class Hw041803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int v = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // 最长子串的起始位置，及其长度
        int start = -1, end = -1, max = 0;
        // 步长差
        int diff;
        int i = 0;
        while (i < a.length()) {
            diff = Math.abs(a.charAt(i) - b.charAt(i));
            if (diff > v) {
                i++;
                continue;
            }

            // 当前子串起始位置及总差之和
            int curStart = i, sum = diff;
            while (sum <= v && i < a.length()) {
                i++;
                if (i >= a.length()) {
                    break;
                }

                diff = Math.abs(a.charAt(i) - b.charAt(i));
                if (diff + sum > v) {
                    break;
                } else {
                    sum += diff;
                }
            }

            if (max < sum) {
                max = sum;
                start = curStart;
                end = i - 1;
            }
        }

        System.out.println(end - start + 1);
    }
}
