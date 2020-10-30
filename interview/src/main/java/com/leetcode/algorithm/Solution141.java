package com.leetcode.algorithm;

/**
 * 141. 环形链表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/3 00:30
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }

            slow = slow.next;
            quick = quick.next.next;
        }

        return true;
    }
}
