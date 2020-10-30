package com.leetcode.algorithm;

/**
 * 148. 排序链表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/21 12:51
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumpHead = new ListNode(0, head);
        ListNode q = head, p = head.next;
        while (p != null) {
            if (q.val <= p.val) {
                q = q.next;
            } else {
                ListNode prev = dumpHead;
                while (prev.next.val < p.val) {
                    prev = prev.next;
                }

                q.next = p.next;
                p.next = prev.next;
                prev.next = p;
            }

            p = q.next;
        }

        return dumpHead.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 求链表长度
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        ListNode dumpHead = new ListNode(0, head);
        for (int i = 1; i < length; i <<= 1) {
            ListNode prev = dumpHead, cur = dumpHead.next;
            while (cur != null) {
                ListNode p = cur;
                for (int j = 1; j < i && cur.next != null; j++) {
                    cur = cur.next;
                }

                ListNode q = cur.next;
                cur.next = null;
                cur = q;
                for (int j = 1; j < i && cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                
                // 合并子链表
                prev.next = merge(p, q);
                while (prev.next != null) {
                    prev = prev.next;
                }

                cur = next;
            }
        }
        return dumpHead.next;
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode dumpHead = new ListNode(0);
        ListNode temp = dumpHead, node1 = p, node2 = q;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }

            temp = temp.next;
        }

        if (node1 != null) {
            temp.next = node1;
        }

        if (node2 != null) {
            temp.next = node2;
        }

        return dumpHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] array = {4, 2, 1, 3};
        ListNode head = listNode.createLinkList(array);
        System.out.println(listNode.toString(head));
        Solution148 cls = new Solution148();
        head = cls.sortList2(head);
        System.out.println(listNode.toString(head));
    }
}
