package com.leetcode.algorithm;

/**
 * 24. 两两交换链表中的节点
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/13 21:43
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;
        ListNode slow, quick, temp = root;
        while (temp.next != null && temp.next.next != null) {
            slow = temp.next;
            quick = temp.next.next;
            temp.next = quick;
            slow.next = quick.next;
            quick.next = slow;
            temp = slow;
        }

        return root.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head.toString((head)));

        System.out.println(head.toString(new Solution24().swapPairs(head)));
    }
}
