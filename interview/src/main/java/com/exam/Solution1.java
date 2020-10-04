package com.exam;

import java.util.*;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/11 20:47
 */
public class Solution1 {
    public int[] removeDuplicate (int[] array) {
        // write code here
        Set<Integer> map = new HashSet<>(16);
        List<Integer> result = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (map.contains(array[i])) {
                continue;
            }

            map.add(array[i]);
            result.add(array[i]);
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
