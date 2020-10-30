package com.leetcode.algorithm;

/**
 * 868. 二进制间距
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 23:48
 */
public class Solution868 {
    public int binaryGap(int n) {
        if (n < 1) {
            return 0;
        }

        int last = -1, ans = 0, bit = 32;
        for (int i = 0; i < bit; i++) {
            if (((n >> i) & 1) > 0) {
                if (last >= 0) {
                    ans = Math.max(ans, i - last);
                }

                last = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution868().binaryGap(22));
    }
}
