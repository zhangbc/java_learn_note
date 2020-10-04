package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/12 11:38
 */
public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null) {
                    min = Math.min(min, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }

        return min;
    }
}
