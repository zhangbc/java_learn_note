package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/12 11:46
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> array = new ArrayList<>(16);

        if (rowIndex < 0) {
            return array;
        }

        array.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            array = getNext(array);
        }

        return array;
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

    public List<Integer> getRow2(int rowIndex) {

        List<Integer> array = new ArrayList<>(16);

        if (rowIndex < 0) {
            return array;
        }

        for (int i = 0; i <= rowIndex; i++) {
            array.add(1);
            for (int j = i - 1; j > 0; j--) {
                array.set(j, array.get(j) + array.get(j - 1));
            }
        }

        return array;
    }
}
