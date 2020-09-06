package com.excise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 样例输入：
 * 3 10 1000
 * 100 5 3
 * 50 3 2
 * 300 3 3
 *
 * 样例输出：
 * 2
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/4 11:50
 */
public class BaiduGift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] row = sc.nextLine().split(" ");
        // 礼物行数
        int n = Integer.parseInt(row[0]);
        // 可承受的总重量
        int m = Integer.parseInt(row[1]);
        // 总预算
        int k = Integer.parseInt(row[2]);

        // 构造礼物矩阵
        List<Gift> giftArray = new ArrayList<>(16);
        while (n > 0) {
            String[] items = sc.nextLine().split(" ");
            Gift gift = new Gift();
            gift.setPrice(Integer.parseInt(items[0]));
            gift.setWeight(Integer.parseInt(items[1]));
            gift.setV(Integer.parseInt(items[2]));
            giftArray.add(gift);
            n--;
        }

        System.out.println(getGiftNumber(giftArray, m, k));
    }

    private static int getGiftNumber(List<Gift> giftArray, int m, int k) {
       List<Gift> gifts = giftArray.stream()
               .sorted(Comparator.comparing(Gift::getV).reversed()
                       .thenComparing(Gift::getPrice)).collect(Collectors.toList());
       int count = 0;
       for (Gift gift: gifts) {
            m -= gift.getWeight();
            k -= gift.getPrice();
            if (m < 0 || k < 0) {
                break;
            }
            count++;
            // 验证
            System.out.printf("%d\t%d\t%d\n", gift.getPrice(), gift.getWeight(), gift.getV());
        }

       return count;
    }

    static class Gift {
        /**
         * 价格
         */
        private int price;
        /**
         * 重量
         */
        private int weight;
        /**
         * 心动值
         */
        private int v;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }
}
