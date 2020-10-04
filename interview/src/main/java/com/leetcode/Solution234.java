package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 234. 回文链表
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/23 11:06
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
        }

        while (!deque.isEmpty()) {
            ListNode top = deque.pollFirst();
            ListNode tail = null;
            if (!deque.isEmpty()) {
                tail = deque.pollLast();
            }

            if (tail != null && top.val != tail.val) {
                return false;
            }
        }

        return true;
    }
}
