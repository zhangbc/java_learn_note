package com.leetcode;

/**
 * 有一个非空的乱序数组，其中有若干个0。请将所有的0，移动到数组末尾。
 * leetcode：283
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 11:14
 */
public class TongHuaShunArray {
    public void moveArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
