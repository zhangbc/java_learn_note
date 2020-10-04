package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/22 19:47
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partition = new ArrayList<>(16);
        if (S == null) {
            return partition;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        int length = S.length();
        for (int i = 0; i < length; i++) {
            map.put(S.charAt(i), i);
        }

        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, map.get(S.charAt(i)));
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }

        return partition;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(new Solution763().partitionLabels(S));
    }
}
