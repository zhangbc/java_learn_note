package com.leetcode.algorithm;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/10 22:01
 */
public class Solution1491 {
    public double average(int[] salary) {
        if (salary == null || salary.length < 3) {
            return 0;
        }

        long sum = 0;
        int min = salary[0], max = salary[0];
        for (int x: salary) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }

        return (sum - max - min) / (double)(salary.length - 2);
    }
}
