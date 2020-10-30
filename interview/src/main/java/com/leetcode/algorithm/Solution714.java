package com.leetcode.algorithm;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 23:15
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int p0 = 0, p1 = -prices[0] - fee, p2, p3;
        for (int i = 1; i < prices.length; i++) {
            p2 = Math.max(p0, p1 + prices[i]);
            p3 = Math.max(p1, p0 - prices[i] - fee);
            p0 = p2;
            p1 = p3;
        }

        return p0;
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int p0 = 0, p1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            p0 = Math.max(p0, p1 + prices[i] - fee);
            p1 = Math.max(p1, p0 - prices[i]);
        }

        return p0;
    }
}
