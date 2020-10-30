package com.leetcode.algorithm;

/**
 * 1290. 二进制链表转整数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/8 23:52
 */
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }

        return res;
    }
}
