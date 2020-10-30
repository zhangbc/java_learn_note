package com.leetcode.algorithm;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/30 22:49
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                low = mid;
                high = mid;
                while (low >= 0 && nums[low] == target) {
                    low--;
                }
                while (high <= nums.length - 1 && nums[high] == target) {
                    high++;
                }

                return new int[]{low + 1, high - 1};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
