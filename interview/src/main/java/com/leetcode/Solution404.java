package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/19 20:39
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left != null && isLeafNode(node.left)) {
                sum += node.left.val;
            }

            if (node.left != null && !isLeafNode(node.left)) {
                nodes.offer(node.left);
            }

            if (node.right != null && !isLeafNode(node.right)) {
                nodes.offer(node.right);
            }
        }

        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
