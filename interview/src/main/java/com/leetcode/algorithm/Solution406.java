package com.leetcode.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/16 21:48
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1 || people[0].length < 1) {
            return people;
        }

        Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        List<int[]> ans = new LinkedList<>();
        for (int[] item: people) {
            ans.add(item[1], item);
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = new Solution406().reconstructQueue(people);
        for (int[] i: ans) {
            System.out.println(Arrays.toString(i));
        }
    }
}
