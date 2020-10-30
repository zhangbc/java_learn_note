package com.leetcode.algorithm;

/**
 * 1518. 换酒问题
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/13 00:40
 */
public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < 0 || numExchange < 0) {
            return 0;
        }

        int sum = 0;
        int cnt = 0;
        while (numBottles > 0) {
            sum++;
            numBottles--;
            cnt++;
            if (cnt == numExchange) {
                numBottles++;
                cnt = 0;
            }
        }

        return cnt == numExchange ? sum + 1 : sum;
    }

    public int numWaterBottles2(int numBottles, int numExchange) {
        if (numBottles < 0 || numExchange < 0) {
            return 0;
        }

        int sum = numBottles;
        int cnt = numBottles;
        while (cnt >= numExchange) {
            cnt -= numExchange;
            sum++;
            cnt++;
        }

        return sum;
    }

    public int numWaterBottles3(int numBottles, int numExchange) {
        if (numBottles < 0 || numExchange < 0) {
            return 0;
        }

        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }
}
