package com.excise;

import java.util.ArrayList;
import java.util.List;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/5 16:14
 */
public class Solution46 {

    List<List<Integer>> array = new ArrayList<>(16);

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return array;
        }

        calcAllPermute(nums, 0, nums.length - 1);
        return array;
    }

    private void calcAllPermute(int[] nums, int from, int to) {
        if (to < 0) {
            return;
        }
        
        if (from == to) {
            List<Integer> items = new ArrayList<>(16);
            for (int i = 0; i <= to; i++) {
                items.add(nums[i]);
            }
            array.add(items);
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums, i, from);
                calcAllPermute(nums, from + 1, to);
                swap(nums, i, from);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        List<List<Integer>> array = new Solution46().permute(arr);
        for (List<Integer> item: array) {
            System.out.println(item.toString());
        }
    }
}
