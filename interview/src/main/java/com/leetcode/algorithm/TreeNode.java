package com.leetcode.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 基本结构
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/13 21:34
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {

    }

    TreeNode(int x) {
        val = x;
    }

    public TreeNode createTree(Integer[] array) {
        Integer item = array[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (index == array.length) {
                break;
            }

            item = array[index++];
            if (item != null) {
                node.left = new TreeNode(item);
                queue.add(node.left);
            }

            if (index == array.length) {
                break;
            }

            item = array[index++];
            if (item != null) {
                node.right = new TreeNode(item);
                queue.add(node.right);
            }
        }

        return root;
    }

    public String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            sb.append(node.val);
            if (node.left != null) {
                nodes.offer(node.left);
            }

            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
