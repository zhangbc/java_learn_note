package com.leetcode.algorithm;

import java.util.PriorityQueue;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 12:04
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (k < 0 || prices == null || prices.length < 1) {
            return 0;
        }

        int length = prices.length;
        if (k >= (length << 1)) {
            return quickSolve(prices);
        }

        int[][] dp = new int[k + 1][length];
        for (int i = 1; i <= k; i++) {
            int temp = -prices[0];
            for (int j = 1; j < length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + temp);
                temp = Math.max(temp, dp[i - 1][j - 1] - prices[j]);
            }
        }

        return dp[k][length - 1];
    }

    private int quickSolve(int[] prices) {
        int length = prices.length, profit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 2;
        Solution188 cls = new Solution188();
        System.out.println(cls.maxProfit(k, prices));
    }
}
