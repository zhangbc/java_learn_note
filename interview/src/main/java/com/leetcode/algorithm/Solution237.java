package com.leetcode.algorithm;

/**
 * 237. 删除链表中的节点
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/14 18:16
 */
public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
