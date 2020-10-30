package com.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/25 14:31
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans++;
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }
}
