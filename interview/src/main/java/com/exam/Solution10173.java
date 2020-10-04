package com.exam;

import java.util.*;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 16:36
 */
public class Solution10173 {
    public ArrayList<ArrayList<String>> groupAnagrams (String[] strs) {
        // write code here
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return arrayLists;
        }

        Map<Integer, ArrayList<String>> map = new HashMap<>(16);
        for (String str: strs) {
            int key = getHashCode(str);
            ArrayList<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>(16);
            }
            list.add(str);
            map.put(key, list);
        }

        for (String str: strs) {
            int key = getHashCode(str);
            if (map.containsKey(key)) {
                arrayLists.add(map.get(key));
                map.remove(key);
            }
        }

        return arrayLists;
    }

    private int getHashCode(String str) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            total += (str.charAt(i) - '0');
        }

        return total;
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat", "test", "stet"};
        ArrayList<ArrayList<String>> arrayLists = new Solution10173().groupAnagrams(arr);
        for (ArrayList<String> strs: arrayLists) {
            System.out.println(strs.toString());
        }
    }
}
