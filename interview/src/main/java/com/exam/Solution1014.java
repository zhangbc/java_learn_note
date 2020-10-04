package com.exam;

import java.util.Scanner;

/**
 * interview
 * 样例输入
 * WASDWWSAD
 * WASSWWAAD
 * 样例输出
 * 120
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/14 19:40
 */
public class Solution1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrayIn = sc.nextLine();
        String arrayOut = sc.nextLine();
        if (arrayIn.length() != arrayOut.length()) {
            System.out.println("两行输入长度不相等！");
            System.exit(1);
        }

        int score = 0;
        for (int i = 0; i < arrayIn.length(); i++) {
            if (arrayIn.charAt(i) == arrayOut.charAt(i)) {
                score += 20;
            } else {
                score -= 10;
                if (score < 0) {
                    score = 0;
                }
            }
        }

        System.out.println(score);
    }
}
