package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/5 11:36
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrays = new ArrayList<>();
        int minCount = 3;
        if (nums == null || nums.length < minCount) {
            return arrays;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - minCount + 1; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 提前终止循环
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            // 加速循环
            if (nums[i] + nums[length - 2] + nums[length - 1] < 0) {
                continue;
            }

            // 变成两数之和
            int low = i + 1, high = length - 1;
            int sum = -nums[i];
            while (low < high) {

                if (nums[low] + nums[high] == sum) {
                    arrays.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;

                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return arrays;
    }
}
