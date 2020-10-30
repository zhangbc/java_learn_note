package com.leetcode.algorithm;

/**
 * 75. 颜色分类
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/7 20:31
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // slow 来交换 0；quick 来交换 1.
        int slow = 0, quick = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, slow);
                if (slow < quick) {
                    swap(nums, i, quick);
                }

                slow++;
                quick++;
            } else if (nums[i] == 1) {
                swap(nums, i, quick);
                quick++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1,1};
        new Solution75().sortColors(array);
    }
}
