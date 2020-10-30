package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 1313. 解压缩编码列表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 21:42
 */
public class Solution1313 {
    public int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        List<Integer> ansList = new ArrayList<>(16);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int freq = nums[i], val = nums[i + 1];
            while (freq > 0) {
                ansList.add(val);
                freq--;
            }
        }

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] decompressRLElist2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }

        int[] ans = new int[size];
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            int freq = nums[i], val = nums[i + 1];
            while (freq > 0) {
                ans[idx++] = val;
                freq--;
            }
        }

        return ans;
    }
}
