package com.leetcode.algorithm;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 23:02
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int p = 0, p0 = 0, p1 = -prices[0], p2, p3;
        for (int i = 1; i < prices.length; i++) {
            p2 = Math.max(p0, p1 + prices[i]);
            p3 = Math.max(p1, p - prices[i]);
            p = p0;
            p0 = p2;
            p1 = p3;
        }

        return p0;
    }
}
