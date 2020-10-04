package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5547. 等差子数组
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/25 10:51
 */
public class Solution5547 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> booleans = new ArrayList<>(16);
        if (nums == null || nums.length < 1 || l == null || r == null || r.length < 1 || r.length != l.length) {
            return booleans;
        }

        for (int i = 0; i < l.length; i++) {
            int[] subArray = getSubArray(nums, l[i], r[i]);
            booleans.add(isArithSequence(subArray));
        }

        return booleans;
    }

    private Boolean isArithSequence(int[] subArray) {
        Arrays.sort(subArray);
        int d = 0;
        for (int i = 1; i < subArray.length; i++) {
            if (i == 1) {
                d = subArray[i] - subArray[i - 1];
                continue;
            }

            if (subArray[i] - subArray[i - 1] != d) {
                return false;
            }
        }

        return true;
    }

    private int[] getSubArray(int[] nums, int start, int end) {
        int[] array = new int[end - start + 1];
        int i = 0;
        while (start <= end) {
            array[i++] = nums[start];
            start++;
        }

        return array;
    }
}
