package com.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 报数游戏 (80%)
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/18 16:07
 */
public class Hw041802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int max = 100;
        if (m <= 1 || m >= max) {
            System.out.println("ERROR!");
            System.exit(1);
        }

        List<Integer> array = new ArrayList<>(16);
        for (int i = 0; i < max; i++) {
            array.add(i + 1);
        }

        int k = 1, index = 0;
        while (array.size() >= m) {
            k++;
            index++;
            if (index >= array.size()) {
                index = index - array.size();
            }

            if (k % m == 0) {
                System.out.println(array.get(index));
                array.remove(index);
                k = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < array.size(); j++) {
            sb.append(array.get(j));
            if (j != array.size() - 1) {
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
    }

}
