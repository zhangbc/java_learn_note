package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 771. 宝石与石头
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/2 20:40
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        if (S == null || J == null) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        int total = 0;
        for (int i = 0; i < J.length(); i++) {
            total += map.getOrDefault(J.charAt(i), 0);
        }
        return total;
    }
}
