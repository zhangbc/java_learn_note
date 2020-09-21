package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 18:12
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }

        while (true) {
            List<String> temp = new ArrayList<>(16);
            for (int num: nums) {
                temp.add(String.valueOf(num));
            }

            k--;
            if (k == 0) {
                return String.join("", temp);
            }

            if (!next(nums)) {
                break;
            }
        }

        return null;
    }

    private boolean next(int[] nums) {
        int i, index = 2;
        for (i = nums.length - index; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            return false;
        }

        int k;
        for (k = nums.length - 1; k > i; k--) {
            if (nums[k] > nums[i]) {
                break;
            }
        }

        nums[i] += nums[k];
        nums[k] = nums[i] - nums[k];
        nums[i] -= nums[k];

        for (int j = i + 1, m = nums.length - 1; j < m; j++, m--) {
            nums[j] += nums[m];
            nums[m] = nums[j] - nums[m];
            nums[j] -= nums[m];
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 9));
    }
}
