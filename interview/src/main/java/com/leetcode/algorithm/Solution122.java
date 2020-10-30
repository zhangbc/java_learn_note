package com.leetcode.algorithm;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/8 18:07
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}
