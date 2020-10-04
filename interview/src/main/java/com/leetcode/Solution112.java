package com.leetcode;

import java.util.Stack;

/**
 * 112. 路径总和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/17 20:06
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int temp = root.val;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp -= node.val;
            System.out.println(temp + " " + node.val);
            if (node.left == null && node.right == null && temp == sum) {
                return true;
            }

            if (node.left == null && node.right == null) {
                temp -= node.val;
            }

            if (node.right != null) {
                temp += node.right.val;
                stack.push(node.right);
            }

            if (node.left != null) {
                temp += node.left.val;
                stack.push(node.left);
            }
        }

        return false;
    }
}
