package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 1672. 最富有客户的资产总量
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/30 22:42
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        if (accounts == null || accounts.length < 1) {
            return 0;
        }

        int ans = 0;
        for (int[] account: accounts) {
            int temp = account[0];
            for (int i = 1; i < account.length; i++) {
                temp += account[i];
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }

    public int maximumWealth2(int[][] accounts) {
        if (accounts == null || accounts.length < 1) {
            return 0;
        }

        return Arrays.stream(accounts).map(ints -> Arrays.stream(ints).sum()).max(Integer::compareTo).get();
    }
}
