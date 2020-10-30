package com.leetcode.algorithm;

/**
 * LCP 19. 秋叶收藏集
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/5 16:30
 */
public class SolutionLcp19 {
    public int minimumOperations(String leaves) {
        int result = 0;
        if (leaves == null || leaves.length() <= 1) {
            return result;
        }

        int length = leaves.length();
        // 注意初始化状态
        int dp = leaves.charAt(0) == 'y' ? 1 : 0;
        int dpMin = dp;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            dp += 2 * isYellow -1;
            if (i != length - 1) {
                ans = Math.min(ans, dpMin - dp);
            }

            dpMin = Math.min(dp, dpMin);
        }

        return ans + (dp + length) / 2;
    }

    public static void main(String[] args) {
        String s = "rrryyyrryyyrr";
        System.out.println(new SolutionLcp19().minimumOperations(s));
    }
}
