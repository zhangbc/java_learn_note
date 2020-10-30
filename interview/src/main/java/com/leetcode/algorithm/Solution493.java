package com.leetcode.algorithm;

/**
 * 493. 翻转对
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/28 13:09
 */
public class Solution493 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        return reversePairsCore(nums, 0, nums.length - 1);
    }

    private int reversePairsCore(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = start + ((end - start) >> 1);
        int left = reversePairsCore(nums, start, mid);
        int right = reversePairsCore(nums, mid + 1, end);

        int ans = left + right;

        int i = start, j = mid + 1;
        while (i <= mid) {
            while (j <= end && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }

            ans += (j - mid - 1);
            i++;
        }

        int[] sorted = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, p = 0;
        while (p1 <= mid || p2 <= end) {
            if (p1 > mid) {
                sorted[p++] = nums[p2++];
            } else if (p2 > end) {
                sorted[p++] = nums[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    sorted[p++] = nums[p1++];
                } else {
                    sorted[p++] = nums[p2++];
                }
            }
        }

        int k = 0;
        while (k < sorted.length) {
            nums[start + k] = sorted[k];
            k++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution493 cls = new Solution493();
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(cls.reversePairs(nums));

        int[] nums2 = {1, 3, 2, 3, 1};
        System.out.println(cls.reversePairs(nums2));
    }
}
