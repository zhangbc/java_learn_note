package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/30 12:33
 */
public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length < 1) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone: stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int max1 = queue.poll(), max2 = queue.poll();
            if (max1 - max2 > 0) {
                queue.offer(max1 - max2);
            }
        }

        return queue.size() > 0 ? queue.poll() : 0;
    }

    /**
     * 官方评分最优解
     */
    public int lastStoneWeight2(int[] stones) {
        if (stones == null || stones.length < 1) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        Arrays.sort(stones);
        int length = stones.length, two = 2;
        while (stones[length - two] != 0) {
            stones[length - 1] -= stones[length - 2];
            stones[length - 2] = 0;
            Arrays.sort(stones);
        }

        return stones[length - 1];
    }
}
