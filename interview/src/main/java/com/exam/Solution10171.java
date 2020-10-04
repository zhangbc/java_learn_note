package com.exam;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 16:18
 */
public class Solution10171 {
    public int[] productExceptSelf (int[] nums) {
        // write code here
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int[] array = new int[nums.length];
        int zero = 0, sum = 1;
        for (int num: nums) {
            if (num == 0) {
                zero++;
            }

            if (num != 0) {
                sum *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zero > 0) {
                    array[i] = 0;
                } else {
                    array[i] = sum / nums[i];
                }
            }

            if (nums[i] == 0) {
                if (zero > 1) {
                    array[i] = 0;
                } else {
                    array[i] = sum;
                }
            }
        }

        return array;
    }
}
