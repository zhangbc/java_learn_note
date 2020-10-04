package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1207. 独一无二的出现次数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/28 22:05
 */
public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int item: arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        return map.values().size() == new HashSet<>(map.values()).size();
    }
}
