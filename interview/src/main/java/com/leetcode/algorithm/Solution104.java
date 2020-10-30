package com.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/11/25 14:31
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
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

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }
}
