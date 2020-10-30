package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/9 13:53
 */
public class Solution06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>(16);
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
