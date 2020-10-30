package com.leetcode.algorithm;

/**
 * LinkList 基本结构
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/13 21:34
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    public ListNode createLinkList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int num: array) {
            p.next = new ListNode(num);
            p = p.next;
        }

        return head.next;
    }

    public String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
