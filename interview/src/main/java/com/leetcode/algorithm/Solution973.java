package com.leetcode.algorithm;

import java.util.*;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 00:04
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length < 1 || points[0].length < 1 || K < 1) {
            return new int[0][0];
        }

        return quickSearch(points, 0, points.length - 1, K - 1);
    }

    private int[][] quickSearch(int[][] points, int low, int high, int k) {

        int pos = partition(points, low, high);
        if (pos == k) {
            return Arrays.copyOf(points, pos + 1);
        }

        return pos > k ? quickSearch(points, low, pos - 1, k) : quickSearch(points, pos + 1, high, k);
    }

    private int partition(int[][] points, int low, int high) {
        double key = getDistinct(points[low]);
        int[] keyArray = points[low];
        while (low < high) {
            while (low < high && getDistinct(points[high]) >= key) {
                high--;
            }
            points[low] = points[high];

            while (low < high && getDistinct(points[low]) <= key) {
                low++;
            }
            points[high] = points[low];
        }

        points[low] = keyArray;
        return low;
    }

    private double getDistinct(int[] point) {
        double res = Math.pow(point[0], 2.0) + Math.pow(point[1], 2.0);
        return Math.sqrt(res);
    }

    public int[][] kClosest2(int[][] points, int K) {
        if (points == null || points.length < 1 || points[0].length < 1 || K < 1) {
            return new int[0][0];
        }

        PriorityQueue<long[]> maxHeap = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o2[0] - o1[0]);
            }
        });

        for (int i = 0; i < points.length; i++) {
            long res = (long) Math.pow(points[i][0], 2.0) + (long) Math.pow(points[i][1], 2.0);
            if (i < K) {
                maxHeap.offer(new long[]{res, i});
            } else {
                if (maxHeap.peek() != null && maxHeap.peek()[0] > res) {
                    maxHeap.poll();
                    maxHeap.offer(new long[]{res, i});
                }
            }
        }

        int[][] ans = new int[K][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            ans[index++] = points[(int) maxHeap.poll()[1]];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] ans = new Solution973().kClosest2(points, 2);
        for (int[] item: ans) {
            System.out.println(Arrays.toString(item));
        }
    }
}
