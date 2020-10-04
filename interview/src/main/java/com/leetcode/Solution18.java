package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/5 11:36
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> arrays = new ArrayList<>();
        int minCount = 4;
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
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 加速循环
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            // 变成三数问题
            int cnt = 2;
            for (int j = i + 1; j < length - cnt; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 提前终止循环
                if (nums[j] + nums[j + 1] + nums[j + 2] + nums[i] > target) {
                    break;
                }

                // 加速循环
                if (nums[j] + nums[i] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                // 变成两数之和
                int low = j + 1, high = length - 1;
                int sum = target - nums[i] - nums[j];
                while (low < high) {

                    if (nums[low] + nums[high] == sum) {
                        arrays.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

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
        }

        return arrays;
    }
}
