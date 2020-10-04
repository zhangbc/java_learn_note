package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * interview
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/10/15 22:05
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }
}
