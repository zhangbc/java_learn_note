package com.leetcode.algorithm;

/**
 * 135. 分发糖果
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/24 16:43
 */
public class Solution135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }

        int length = ratings.length;
        int[] left = new int[length];
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 0, ans = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }

            ans += Math.max(left[i], right);
        }

        return ans;
    }

    public int candy1(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }

        int length = ratings.length, ans = 1, asc = 1, desc = 0, pre = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                desc = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ans += pre;
                asc = pre;
            } else {
                desc++;
                if (desc == asc) {
                    desc++;
                }

                ans += desc;
                pre = 1;
            }
        }

        return ans;
    }
}
