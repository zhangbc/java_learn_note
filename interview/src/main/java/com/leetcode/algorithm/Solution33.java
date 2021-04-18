package com.leetcode.algorithm;

/**
 * 33. 搜索旋转排序数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2021/4/17 23:42
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        if (nums.length == 1 || nums[0] == target) {
            return nums[0] == target ? 0 : -1;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i - 1;
            }
        }

        int start , end;
        start = binarySearch(nums, 0, index, target);
        end = binarySearch(nums, index + 1, nums.length - 1, target);

        return start >= 0 ? start : (end >= 0 ? end : -1);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return  mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        if (nums.length == 1 || nums[0] == target) {
            return nums[0] == target ? 0 : -1;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return  mid;
            }

            // 数组中的值互不相同
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
