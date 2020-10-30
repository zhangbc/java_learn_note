package com.leetcode.algorithm;

/**
 * 19. 删除链表的倒数第 N 个节点
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/18 09:57
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode slow, quick = head;
        for (int i = 0; i < n; i++) {
            if (quick == null) {
                return null;
            }

            quick = quick.next;
        }

        slow = root;
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return root.next;
    }
}
