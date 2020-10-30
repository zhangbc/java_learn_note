package com.leetcode.algorithm;

/**
 * 2. 两数相加
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/4 10:39
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(0);
        ListNode p = merge;
        int x, y, s, bit = 0;
        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            s = (x + y + bit) % 10;
            bit = (x + y + bit) / 10;

            p.next = new ListNode(s);
            p = p.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (bit != 0) {
            p.next = new ListNode(bit);
        }

        return merge;
    }
}
