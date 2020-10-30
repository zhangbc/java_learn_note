package com.leetcode.algorithm;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/12/30 23:26
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int count = 3;
        if (nums == null || nums.length < count) {
            return 0;
        }

        Arrays.sort(nums);
        int ans = 0, diff = Integer.MAX_VALUE, length = nums.length - 1;
        for (int i = 0; i < length - 1; i++) {
            int low = i + 1, high = length;
            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high];
                if (Math.abs(temp - target) < diff) {
                    diff = Math.abs(temp - target);
                    ans = temp;
                } else if (temp < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 2;
        Solution16 cls = new Solution16();
        System.out.println(cls.threeSumClosest(nums, target));
    }
}
