package com.leetcode.algorithm;

/**
 * 123. 买卖股票的最佳时机 III
 * 参考：https://leetcode-cn.com/circle/article/qiAgHn/
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 19:45
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // p0，p1第一次买卖，p2，p3第二次买卖
        int p0 = 0, p1 = -prices[0], p2 = 0, p3 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            p2 = Math.max(p2, p3 + prices[i]);
            p3 = Math.max(p3, p0 - prices[i]);
            p0 = Math.max(p0, p1 + prices[i]);
            p1 = Math.max(p1, -prices[i]);
        }

        return p2;
    }
}
