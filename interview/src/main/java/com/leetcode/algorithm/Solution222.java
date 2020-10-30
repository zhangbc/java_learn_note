package com.leetcode.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/24 11:19
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int ans = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            ans++;
            if (node.left != null) {
                nodes.offer(node.left);
            }

            if (node.right != null) {
                nodes.offer(node.right);
            }
        }

        return ans;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            h++;
            node = node.left;
        }

        int low = 1 << h, high = (1 << (h + 1)) - 1;
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (exists(root, h, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int h, int k) {
        int bits = 1 << (h - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
