package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/13 21:31
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>(16);
        if (root == null) {
            return array;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount;
        while (!queue.isEmpty()) {
            levelCount = queue.size();
            List<Integer> level = new ArrayList<>(16);
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            array.add(0, level);
        }

        return array;
    }
}
