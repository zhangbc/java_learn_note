package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/27 13:06
 */
public class Solution204 {
    /**
     * 经典算法超时
     */
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        int ans = 0, i = 2;
        while (i < n) {
            if (isPrime(i++)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.floor(Math.sqrt(number)); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 厄拉多塞筛法
     */
    public int countPrimes2(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] primers = new boolean[n];
        Arrays.fill(primers, true);

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primers[i]) {
                ans++;
                for (int j = i + i; j < n; j += i) {
                    primers[j] = false;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(999983));
        System.out.println(new Solution204().countPrimes2(999983));
    }
}
