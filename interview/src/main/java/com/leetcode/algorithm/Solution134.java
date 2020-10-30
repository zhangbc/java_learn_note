package com.leetcode.algorithm;

/**
 * 134. 加油站
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/18 15:17
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length < 1 || cost == null || cost.length < 1) {
            return -1;
        }

        int length = gas.length, i = 0;
        while (i < length) {
            int total = gas[i], j = i;
            while (total >= cost[j]) {
                total -= cost[j];
                j = (j + 1) % length;
                if (j == i) {
                    return i;
                }
                total += gas[j];
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Solution134().canCompleteCircuit(gas, cost));
    }
}
