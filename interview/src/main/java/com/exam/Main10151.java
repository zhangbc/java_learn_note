package com.exam;

import java.util.Scanner;

/**
 * 现在你在玩一款游戏，叫做节奏小师。它有三种判定
 *
 * P : Perfect 完美，加200分。
 *
 * G : Great 很棒，加100分。
 *
 * M : Miss 错过，不加分也不扣分，但累计三次Miss就会输掉游戏。
 *
 * 另外有一种奖励是连击奖励。一旦连续三个Perfect之后，后续连击的Perfect分数将变成250分，但一旦打出了Great或者Miss则连击数将重新开始计算。
 *
 * 你的任务是根据游戏记录计算分数。特别地，失败记为零分。
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/15 20:47
 */
public class Main10151 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.length() > 10000) {
                System.out.println("输入不合法！");
                System.exit(1);
            }

            int p = 0;
            int m = 0;
            long sum = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'P') {
                    if (p >= 3) {
                        sum += 250;
                    } else {
                        sum += 200;
                    }
                    p++;
                } else if (line.charAt(i) == 'G') {
                    p = 0;
                    sum += 100;
                } else if (line.charAt(i) == 'M') {
                    m++;
                    if (m == 3) {
                        break;
                    }
                }else {
                    System.out.println("输入不合法！");
                    System.exit(1);
                }
            }

            System.out.println(sum);
        }
}
