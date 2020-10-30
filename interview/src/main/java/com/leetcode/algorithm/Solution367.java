package com.leetcode.algorithm;

/**
 * 367. 有效的完全平方数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 22:49
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        if (num == 0 || num == 1) {
            return true;
        }

        int n = 2;
        while (n <= (num >> 1)) {
            if (n == num / n && num % n == 0) {
                return true;
            }

            if (n > num / n) {
                return false;
            }
            n++;
        }

        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num < 0) {
            return false;
        }

        if (num == 0 || num == 1) {
            return true;
        }

        int low = 2, high = num >> 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid == num / mid && num % mid == 0) {
                return true;
            }

            if (mid < num / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare(2147483647));
    }
}
