package com.leetcode.algorithm;

/**
 * 147. 对链表进行插入排序
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/20 11:05
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        ListNode q = head, p = head.next;
        while (p != null) {
            if (q.val <= p.val) {
                q = q.next;
            } else {
                ListNode prev = dumHead;
                while (prev.next.val < p.val) {
                    prev = prev.next;
                }

                q.next = p.next;
                p.next = prev.next;
                prev.next = p;
            }

            p = q.next;
        }

        return dumHead.next;
    }
}
