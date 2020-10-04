package com.leetcode;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/4 11:10
 */
public class SolutionF3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }
}
