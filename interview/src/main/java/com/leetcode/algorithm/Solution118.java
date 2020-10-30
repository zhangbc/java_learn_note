package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/12 11:46
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> arrays = new ArrayList<>(16);

        if (numRows < 1) {
            return arrays;
        }

        List<Integer> array = new ArrayList<>(16);
        array.add(1);
        arrays.add(array);
        for (int i = 1; i < numRows; i++) {
            array = getNext(arrays.get(i - 1));
            arrays.add(array);
        }

        return arrays;
    }

    private List<Integer> getNext(List<Integer> array) {
        List<Integer> ans = new ArrayList<>(16);
        int size = array.size();
        ans.add(array.get(0));
        for (int i = 1; i < size; i++) {
            ans.add(array.get(i - 1) + array.get(i));
        }

        ans.add(array.get(size - 1));
        return ans;
    }
}
