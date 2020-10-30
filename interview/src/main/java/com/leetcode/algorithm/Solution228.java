package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 23:19
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>(16);
        if (nums == null || nums.length < 1) {
            return ans;
        }

        int start = nums[0], end = nums[0];
        int idx = 1;
        while (idx < nums.length) {
            if (nums[idx] - end == 1) {
                end = nums[idx];
            } else {
                addAnswerList(ans, start, end);
                start = end = nums[idx];
            }

            idx++;
        }

        addAnswerList(ans, start, end);

        return ans;
    }

    private void addAnswerList(List<String> ans, int start, int end) {
        if (start < end) {
            ans.add(start + "->" + end);
        } else {
            ans.add(String.valueOf(start));
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> ans = new Solution228().summaryRanges(nums);
        System.out.println(ans.toString());
    }
}
