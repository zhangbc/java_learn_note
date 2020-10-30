package com.leetcode.algorithm;

/**
 * 142. 环形链表 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/10 14:44
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, p = head;
        ListNode quick = head;
        while (quick != null) {
            if (quick.next == null) {
                return null;
            }

            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) {
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return head.next;
    }
}
