package com.leetcode.algorithm;

import java.util.*;

/**
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/31 20:59
 */
public class Solution381 {
}


class RandomizedCollection {

    Map<Integer, Set<Integer>> idx;
    List<Integer> array;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<>(16);
        array = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        array.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>(16));
        set.add(array.size() - 1);
        idx.put(val, set);

        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }

        Iterator<Integer> iterator = idx.get(val).iterator();
        int i = iterator.next();
        int index = array.size() - 1;
        idx.get(val).remove(i);
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }

        if (i < array.size() - 1) {
            int last = array.get(index);
            array.set(i, last);
            idx.get(last).remove(index);
            idx.get(last).add(i);
        }

        array.remove(index);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return array.get((int) (Math.random() * array.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */