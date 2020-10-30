package com.leetcode.algorithm;

/**
 * 21. 合并两个有序链表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/21 15:49
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode merge = new ListNode(0);
        ListNode p = merge;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        p.next = l1 == null ? l2 : l1;

        return merge.next;
    }
}
