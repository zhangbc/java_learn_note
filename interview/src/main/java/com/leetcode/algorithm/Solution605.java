package com.leetcode.algorithm;

/**
 * 605. 种花问题
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/19 09:52
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < 1) {
            return false;
        }

        int placeNumber = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                placeNumber++;
            }
        }

        return placeNumber >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0};
        boolean place = new Solution605().canPlaceFlowers(flowerbed, 1);
        System.out.println(place);
    }
}
