package com.leetcode.algorithm;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/28 13:17
 */
public class Solution121 {
    public int maxProfit(int[] prices)  {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int min = prices[0], ans = 0;
        for (int price: prices) {
            if (price < min) {
                min = price;
            }

            ans = Math.max(price - min, ans);
        }

        return ans;
    }
}
